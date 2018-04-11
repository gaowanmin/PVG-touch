package com.rtmap.traffic.touch.model.vo;

/**
 * 操作结果
 *
 * @author xuhailong
 * @Date 2017/3/9
 */
public class OpRst<T> {

    private int code; // 0：操作成功； 非0的为错误代码
    private String msg;
    private T rst;

    public OpRst() {
    }

    public OpRst(int code) {
        this.code = code;
    }

    public OpRst(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public OpRst(int code, T rst) {
        super();
        this.code = code;
        this.rst = rst;
    }

    public OpRst(int code, String msg, T rst) {
        this.code = code;
        this.msg = msg;
        this.rst = rst;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRst() {
        return rst;
    }

    public void setRst(T rst) {
        this.rst = rst;
    }

}
