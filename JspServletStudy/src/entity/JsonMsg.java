package entity;

public class JsonMsg {

    public final static int STATUS_SUCCESS=200;
    public final static int STATUS_FAIL=400;
    public final static int STATUS_ERROR=500;
    public final static int STATUS_AUTH=100;

    private int status;     //标志位，代表处理的结果
    private String msg;     //提示消息
    private Object data;    //数据

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonMsg{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public JsonMsg(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonMsg(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public JsonMsg() {
        super();
    }

    public static JsonMsg makeSuccess(String msg,Object data){
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.status = STATUS_SUCCESS;
        jsonMsg.data = data;
        jsonMsg.msg = msg;
        return jsonMsg;
    }

    public static JsonMsg makeFail(String msg,Object data){
        JsonMsg jsonMsg = new JsonMsg();
        jsonMsg.status = STATUS_FAIL;
        jsonMsg.data = data;
        jsonMsg.msg = msg;
        return jsonMsg;
    }

}
