package net.pst.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "todes", url = "https://a.todes.by:13201/reposService/api/v1/repository")
public interface ApiProxy {
    @GetMapping(value = "/{id}")
    String getById(@PathVariable("id") Integer id);

    @GetMapping(value = "/{id}/children")
    String getChildren(@PathVariable("id") Integer id);

    @GetMapping(value = "/root")
    String getRoot();
}
