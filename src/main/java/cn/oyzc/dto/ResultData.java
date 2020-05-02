package cn.oyzc.dto;

/**
 * @ClassName ResultData
 * @Description 接口返回数据
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午1:17
 * @Version 1.0
 */
public class ResultData<T> {

    private int code;

    private T data;

    private String msg;

    /**
     * 返回正确数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultData<T> data(T data) {
        return new ResultData<>(data);
    }

    /**
     * 返回错误数据
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResultData<T> data(String msg) {
        return new ResultData<>(CODEMSG.SYSTEM_ERROR_RESULT.getCode(), msg);
    }


    private ResultData(T data) {
        this.code = CODEMSG.SUCCESS_RESULT.getCode();
        this.msg = CODEMSG.SUCCESS_RESULT.getMsg();
        this.data = data;
    }

    private ResultData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultData(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
