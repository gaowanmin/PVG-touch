package com.rtmap.traffic.touch.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类
 *
 * @author liqingshan
 * @date 2016年4月12日
 */
public class HttpClientUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * 默认连接超时时间(毫秒) 由于目前的设计原因，该变量定义为静态的，超时时间不能针对每一次的请求做定制 备选优化方案：
     * 1.考虑是否重新设计这个工具类，每次请求都需要创建一个实例; 2.请求方法里加入超时时间参数
     * 或者说是否没必要定制,10秒是一个比较适中的选择，但有些请求可能就是需要快速给出结果T_T
     */
    public static final int CONNECT_TIMEOUT = 10 * 1000;

    /**
     * 发送GET方法的请求
     *
     * @param url 发送请求的URL，其后的请求参数应该是 ?name1=value1&name2=value2 的形式。
     * @return 响应结果
     */
    public static String get(String url) {
        CloseableHttpClient httpclient = getCloseableHttpClient();

        try {
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpget);

            return getResponseContent(response);
        } catch (ClientProtocolException e) {
            logger.error("客户端协议异常！", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式异常！", e);
        } catch (IOException e) {
            logger.error("网络IO异常！", e);
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    logger.error("httpclient连接关闭异常！", e.toString());
                }
            }
        }

        return null;
    }

    /**
     * 发送POST方法的请求
     *
     * @param url    发送请求的 URL
     * @param params 请求参数键值对集合
     * @return 响应结果
     */
    public static String post(String url, Map<String, String> params) {
        List<NameValuePair> nvps = null;
        if (params != null && params.size() > 0) {
            nvps = new ArrayList<>();

            for (String key : params.keySet()) {
                nvps.add(new BasicNameValuePair(key, params.get(key)));
            }
        }

        HttpEntity entity;
        try {
            entity = new UrlEncodedFormEntity(nvps, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式异常！", e);
            return null;
        }

        return executePost(url, entity);
    }

    /**
     * 发送POST方法的请求
     *
     * @param url        发送请求的 URL
     * @param jsonString 请求参数，json格式的字符串
     * @return 响应结果
     */
    public static String post(String url, String jsonString) {
        StringEntity entity = new StringEntity(jsonString, ContentType.APPLICATION_JSON);

        return executePost(url, entity);
    }

    private static String executePost(String url, HttpEntity entity) {
        CloseableHttpClient httpclient = getCloseableHttpClient();

        try {
            HttpPost httpost = new HttpPost(url);
            httpost.setEntity(entity);
            CloseableHttpResponse response = httpclient.execute(httpost);

            return getResponseContent(response);
        } catch (ClientProtocolException e) {
            logger.error("客户端协议异常！", e);
        } catch (IOException e) {
            logger.error("网络IO异常！", e);
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    logger.error("httpclient连接关闭异常！", e.toString());
                }
            }
        }

        return null;
    }

    /**
     * 上传文件
     *
     * @param url       发送请求的 URL
     * @param paramData 请求的文本参数
     * @param files     上传的文件
     * @return 文件地址
     */
    public static String upload(String url, String paramData, List<File> files) {
        CloseableHttpClient httpclient = getCloseableHttpClient();
        HttpPost request = new HttpPost(url);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        for (File file : files) {
            if (file.isFile()) {
                FileBody fb = new FileBody(file);
                builder.addPart("media", fb);
            } else {
                logger.warn("此文件不是有效的文件类型！", file.getPath());
            }
        }

        if (null != paramData) {
            builder.addPart("description", new StringBody(paramData, ContentType.APPLICATION_JSON));
            // builder.addPart("description", new StringBody(paramData, ContentType.TEXT_PLAIN));
        }

        request.setEntity(builder.build());
        CloseableHttpResponse response;
        try {
            response = httpclient.execute(request);
            return getResponseContent(response);
        } catch (ClientProtocolException e) {
            logger.error("客户端协议异常！", e);
        } catch (IOException e) {
            logger.error("网络IO异常！", e);
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    logger.error("httpclient连接关闭异常！", e.toString());
                }
            }
        }

        return null;
    }

    /**
     * 下载文件
     *
     * @param url 发送请求的URL，其后的请求参数应该是 ?name1=value1&name2=value2 的形式。
     * @return 文件的字节数组
     */
    public static byte[] download(String url) {
        CloseableHttpClient httpclient = getCloseableHttpClient();
        InputStream in = null;
        BufferedInputStream bufin = null;
        ByteArrayOutputStream byteOut = null;

        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpclient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            in = entity.getContent();

            long length = entity.getContentLength();
            if (length <= 0) {
                logger.info("下载文件不存在！");
                return null;
            }

            bufin = new BufferedInputStream(in);
            int buffSize = 1024;
            byteOut = new ByteArrayOutputStream(buffSize);
            byte[] temp = new byte[buffSize];
            int size;
            while ((size = bufin.read(temp)) != -1) {
                byteOut.write(temp, 0, size);
            }

            return byteOut.toByteArray();
        } catch (ClientProtocolException e) {
            logger.error("客户端协议异常！", e);
        } catch (IOException e) {
            logger.error("网络IO异常！", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("文件输入流关闭异常！", e);
                }
            }

            if (bufin != null) {
                try {
                    bufin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (byteOut != null) {
                try {
                    byteOut.close();
                } catch (IOException e) {
                    logger.error("文件输出流关闭异常！", e.toString());
                }
            }

            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    logger.error("httpclient连接关闭异常！", e.toString());
                }
            }
        }

        return null;
    }

    /**
     * 获取自定义的httpclient请求对象
     *
     * @return httpclient请求对象
     */
    private static CloseableHttpClient getCloseableHttpClient() {
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(CONNECT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(CONNECT_TIMEOUT).build();
        return HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }

    /**
     * 获取响应的文本内容
     *
     * @param response http响应
     * @return 响应的文本内容
     */
    private static String getResponseContent(CloseableHttpResponse response) {
        HttpEntity resEntity = response.getEntity();

        if (resEntity != null) {
            try {
                return EntityUtils.toString(resEntity, "UTF-8");
            } catch (IOException e) {
                logger.error("获取请求返回实体信息异常！", e);
            } finally {
                try {
                    response.close();
                    EntityUtils.consume(resEntity);
                } catch (IOException e) {
                    logger.error("网络响应实体关闭异常！", e);
                }
            }
        }

        return null;
    }
}
