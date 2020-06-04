package com.wigen.authapi;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangweiqing
 */
@Data
@Builder
@NoArgsConstructor
public class Response<T> {

    private String code;

    private String message;

    private T data;
}
