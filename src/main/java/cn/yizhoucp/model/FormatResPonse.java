package cn.yizhoucp.model;

import lombok.Data;

@Data
public class FormatResPonse {
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    public FormatResPonse(){}

    /**
     * @param obg
     * @param message
     * @return
     */
    public FormatResPonse success(Object obg, String message){
        FormatResPonse formatResPonse = new FormatResPonse();
        formatResPonse.setIsok(true);
        formatResPonse.setCode(200);
        formatResPonse.setData(obg);
        formatResPonse.setMessage(message);
        return formatResPonse;
    }

    /**
     * 需要oject结果响应
     * @param obg
     * @return
     */
    public FormatResPonse success(Object obg){
        FormatResPonse formatResPonse = new FormatResPonse();
        formatResPonse.setIsok(true);
        formatResPonse.setCode(200);
        formatResPonse.setData(obg);
        formatResPonse.setMessage("请求响应成功");
        return formatResPonse;
    }

    /**
     * 无参响应结果
     * @return
     */
    public FormatResPonse success(){
        FormatResPonse formatResPonse = new FormatResPonse();
        formatResPonse.setIsok(true);
        formatResPonse.setCode(200);
        formatResPonse.setMessage("请求响应成功");
        return formatResPonse;
    }
}
