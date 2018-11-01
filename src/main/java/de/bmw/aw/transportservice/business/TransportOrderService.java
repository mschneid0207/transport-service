package de.bmw.aw.transportservice.business;

import de.bmw.aw.transportservice.data.TransportOrderRepository;
import de.bmw.aw.transportservice.model.StorageBin;
import de.bmw.aw.transportservice.model.TransportOrder;
import de.bmw.aw.transportservice.model.TransportUnit;
import de.bmw.aw.transportservice.proxy.StorageBinServiceProxy;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log
public class TransportOrderService {

    @Autowired
    public TransportUnitService transportUnitService;

    @Autowired
    public StorageBinServiceProxy storageBinServiceProxy;

    @Autowired
    public TransportOrderRepository repository;

    public TransportOrder createTransportOrder(TransportUnit transportUnit) {
        // 1. exist TU -> if not create one
        log.info("createTransportOrder was called");
        TransportUnit tu = transportUnitService.existTU(transportUnit);
        // 2. find free storage bin
        StorageBin freeStorageBin = storageBinServiceProxy.findFreeStorageBin();
        log.info("free storage bin: " + freeStorageBin.getId());
        // 3. create transport order
        TransportOrder transportOrder = TransportOrder.builder().barCode(transportUnit.getBarCode())
                .location(100)
                .target(freeStorageBin.getId().intValue())
                .build();
        return repository.save(transportOrder);
    }


}
