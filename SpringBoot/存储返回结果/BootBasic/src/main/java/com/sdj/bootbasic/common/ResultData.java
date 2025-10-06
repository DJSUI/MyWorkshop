package com.sdj.bootbasic.common;

public class ResultData<T> {

    //全局静态变量， 外部可以自由使用，方便给success状态赋予数值
    private static final String SUCCESS = "0";
    private static final String ERROR = "-1";
    //  控制整体业务流程的失败或者成功
    private String status;
    // 返回状态码
    private Integer code;
    // 将错误消息放入
    private String  message;
    // 具体分返回数据
    private T  data;
//  有参构造方法，方便类内部调用

    public ResultData(String status, Integer code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public ResultData(String status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    // 定义静态方法方便外部直接使用
    // 成功时的静态方法创建Result对象
    public static <T> ResultData<T> SuccessData(T data) {
        return new ResultData<>(SUCCESS, 200,"处理成功",data);
    }



    // 失败时的静态方法创建Result对象
    public static <T> ResultData<T> FailData(Integer code , String message) {
        return new ResultData<>(ERROR, 500, "处理失败");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
