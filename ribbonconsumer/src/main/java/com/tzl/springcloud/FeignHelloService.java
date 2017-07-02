package com.tzl.springcloud;

import api.IHelloServiceApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by tangzhilong on 17/7/1.
 */
@FeignClient("HELLOSERVICE")
public interface FeignHelloService extends IHelloServiceApi{
}
