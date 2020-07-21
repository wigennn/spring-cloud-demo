package com.wigen.common.resp;

import java.util.HashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = -633534992245456993L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    public Result() {}

    public Result(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    public Result(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }

    public static Result success(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result success(String msg) {
        return success(msg, null);
    }

    public static Result success(Object data) {
        return success("操作成功", data);
    }

    public static Result error(String msg, Object data) {
        return new Result(500, msg, data);
    }

    public static Result error(String msg) {
        return error(msg, null);
    }

    public static Result error(Object data) {
        return error("操作失败", data);
    }

    public static Result error(int code, String msg) {
        return new Result(code, msg, null);
    }
}
