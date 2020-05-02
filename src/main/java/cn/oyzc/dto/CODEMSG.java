package cn.oyzc.dto;

/**
 * @ClassName CODEMSG
 * @Description 接口返回枚举
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午1:14
 * @Version 1.0
 */
public enum CODEMSG {

    SUCCESS_RESULT(200, "操作成功"),
    SYSTEM_ERROR_RESULT(-200, "操作失败");

    private int code;

    private String msg;

    CODEMSG(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

}
