package com.wigen.gatewaycenter;

import lombok.Builder;
import lombok.Data;

/**
 * @author wangweiqing
 */
@Data
@Builder
public class Response<T> {

    private String code;

    private String message;

    private T data;
}
