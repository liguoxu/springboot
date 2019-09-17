package root.code.resultCode;

public enum ResultCode {
    SUCCESS(200, "运行成功"),
    TEST_NUMBER_ERROR(201, "考生号有误"),
    CARD_ID_ERROR(202, "身份证号有误"),
    CHECK_CODE_ERROE(203, "验证码错误"),
    FILE_NOT_EXCEL(204,  "文件不是Excel"),
    IO_READ_ERROR(205, "文件读取失败");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
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
