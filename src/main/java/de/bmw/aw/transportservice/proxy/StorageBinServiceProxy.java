package de.bmw.aw.transportservice.proxy;

import de.bmw.aw.transportservice.model.StorageBin;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// Version 1 call storage bin business by hard url
//@FeignClient(name = "storage-bin-business", url = "localhost:8000")
// Version 2 call storage bin business by business name with ribbon (automatic load balancing)
//@FeignClient(name = "storage-bin-business")
// Version 3 call storage bin business by zuul api gateway
@FeignClient(name = "api-gateway")
@RibbonClient(name = "storage-bin-business")
public interface StorageBinServiceProxy {

    // Version 2
    //@GetMapping("/free_storage_bin")
    // Version 3 necessary to set the business name
    @GetMapping("/storage-bin-service/free_storage_bin")
    public StorageBin findFreeStorageBin();
}
