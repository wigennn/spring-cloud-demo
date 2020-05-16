package com.wigen.gatewaycenter;

import lombok.Builder;
import lombok.Data;

/**
 * @author 18070900
 */
@Data
@Builder
public class Response {

    private String code;

    private String message;

    private Object data;
}
