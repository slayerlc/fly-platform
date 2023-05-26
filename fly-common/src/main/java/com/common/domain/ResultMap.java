package com.common.domain;

import com.common.constant.Constant;

import java.io.Serializable;

/**
 * 通用结果集
 * @param <T>
 */
public class ResultMap<T> implements Serializable {
        private static final long serialVersionUID = 1L;

        /** 成功 */
        public static final int SUCCESS = Constant.SUCCESS_CODE;

        /** 失败 */
        public static final int FAIL = Constant.FAIL;

        private int code;

        private String msg;

        private T data;

        public static <T> ResultMap<T> ok()
        {
            return restResult(null, SUCCESS, null);
        }

        public static <T> ResultMap<T> ok(T data)
        {
            return restResult(data, SUCCESS, null);
        }

        public static <T> ResultMap<T> ok(T data, String msg)
        {
            return restResult(data, SUCCESS, msg);
        }

        public static <T> ResultMap<T> fail()
        {
            return restResult(null, FAIL, null);
        }

        public static <T> ResultMap<T> fail(String msg)
        {
            return restResult(null, FAIL, msg);
        }

        public static <T> ResultMap<T> fail(T data)
        {
            return restResult(data, FAIL, null);
        }

        public static <T> ResultMap<T> fail(T data, String msg)
        {
            return restResult(data, FAIL, msg);
        }

        public static <T> ResultMap<T> fail(int code, String msg)
        {
            return restResult(null, code, msg);
        }

        private static <T> ResultMap<T> restResult(T data, int code, String msg)
        {
            ResultMap<T> apiResult = new ResultMap<>();
            apiResult.setCode(code);
            apiResult.setData(data);
            apiResult.setMsg(msg);
            return apiResult;
        }

        public int getCode()
        {
            return code;
        }

        public void setCode(int code)
        {
            this.code = code;
        }

        public String getMsg()
        {
            return msg;
        }

        public void setMsg(String msg)
        {
            this.msg = msg;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public static <T> Boolean isError(ResultMap<T> ret)
        {
            return !isSuccess(ret);
        }

        public static <T> Boolean isSuccess(ResultMap<T> ret)
        {
            return ResultMap.SUCCESS == ret.getCode();
        }

}
