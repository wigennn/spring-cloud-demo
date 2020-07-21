package com.wigen.auth.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Data
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -6406145632229255196L;

    private String userName;

    private String password;

    private String name;

    private String phone;

    private String roleId;

    private Integer status;
}
