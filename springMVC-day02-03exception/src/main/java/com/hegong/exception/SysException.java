package com.hegong.exception;

/**
 * @author 14767
 * 自定义异常类
 */
public class SysException extends Exception {
    public SysException(String message) {
        this.message = message;
    }

    /**
     * 存储提示的信息
     */
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
