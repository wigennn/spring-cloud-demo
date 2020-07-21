package com.wigen.auth.core.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Data
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = -9171807945576747924L;

    private String userName;

    private String password;
}
