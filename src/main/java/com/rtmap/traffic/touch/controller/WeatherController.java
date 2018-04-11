package com.rtmap.traffic.touch.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rtmap.traffic.touch.model.vo.OpRst;
import com.rtmap.traffic.touch.util.DateUtil;
import com.rtmap.traffic.touch.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhailong
 * @Date 2017/8/10
 */
@RestController
@RequestMapping("weather")
public class WeatherController {

    private Logger logger = LoggerFactory.getLogger(WeatherController.class);

    //预报url
    @Value("${weather.forecastUrl}")
    private String weatherForecastUrl;

    //指数url
    @Value("${weather.suggestionUrl}")
    private String weatherSuggestionUrl;

    //key
    @Value("${weather.key}")
    private String key;

    //地方
    @Value("${weather.location}")
    private String location;


    //用来保存天气数据 默认保存一天的
    private Map<String, Map<String, String>> weatherData = new HashMap<>(1);

    /**
     * 获取天气预报
     */
    @GetMapping(value = "forecast")
    public OpRst forecast() {
        String dateKey = DateUtil.date2String(new Date(), DateUtil.FORMAT_DATE);
        Map<String, String> weatherMap = new HashMap<>();
        if (weatherData.containsKey(dateKey)) {
            weatherMap = weatherData.get(dateKey);
        } else {
            weatherData.clear();
            String weatherStr = HttpClientUtils.get(weatherForecastUrl + "?key=" + key + "&city=" + location);
            String suggestStr = HttpClientUtils.get(weatherSuggestionUrl + "?key=" + key + "&city=" + location);
            if (!StringUtils.isEmpty(weatherStr)) {
                JSONObject weatherJson = JSONObject.parseObject(weatherStr);
                JSONArray heWeather5 = weatherJson.getJSONArray("HeWeather5");
                JSONObject jsonObject = heWeather5.getJSONObject(0);
                weatherMap.put("basic", jsonObject.getString("basic"));
                weatherMap.put("status", jsonObject.getString("status"));
                weatherMap.put("daily_forecast", jsonObject.getString("daily_forecast"));
                if (!StringUtils.isEmpty(suggestStr)) {
                    JSONObject suggestJson = JSONObject.parseObject(suggestStr);
                    JSONArray suggestArray = suggestJson.getJSONArray("HeWeather5");
                    JSONObject suggest = suggestArray.getJSONObject(0);
                    weatherMap.put("suggestion", suggest.getString("suggestion"));
                }
                logger.debug("==>获取天气预报:" + JSONObject.toJSON(weatherMap));
                weatherData.put(dateKey, weatherMap);
            }
        }

        return new OpRst<>(0, "success", weatherMap);

    }


}
