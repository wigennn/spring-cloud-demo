package com.wigen.gatewaycenter;

import lombok.Builder;
import lombok.Data;

/**
 *
 */
@Data
@Builder
public class Response {

    private String code;

    private String message;

    private Object data;
}
