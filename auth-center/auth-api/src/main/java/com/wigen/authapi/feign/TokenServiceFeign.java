package com.wigen.authapi.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@FeignClient("auth-center")
public interface TokenServiceFeign {


}
