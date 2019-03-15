package com.aibaoxian.auth.feign;

import com.aibaoxian.auth.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "auth")
public interface HelloRemote {

    @RequestMapping(value = "/redis/get", method = {RequestMethod.POST})
    public R<String> get(@RequestParam(value = "key") String key, @RequestParam(value = "ms") int ms);


}
