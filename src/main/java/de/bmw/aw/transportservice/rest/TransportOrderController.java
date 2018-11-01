package de.bmw.aw.transportservice.rest;

import de.bmw.aw.transportservice.business.TransportOrderService;
import de.bmw.aw.transportservice.business.TransportUnitService;
import de.bmw.aw.transportservice.model.TransportOrder;
import de.bmw.aw.transportservice.model.TransportUnit;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log
public class TransportOrderController {

    @Autowired
    private TransportUnitService transportUnitService;

    @Autowired
    private TransportOrderService transportOrderService;


    @PostMapping("/transport_order")
    public TransportOrder createTransportOrder(@RequestBody TransportUnit transportUnit) {
        // TODO response with correct http status

        TransportOrder transportOrder = transportOrderService.createTransportOrder(transportUnit);
        //return new ResponseEntity(transportOrder, HttpStatus.CREATED);
        return transportOrder;
    }

    @GetMapping("/transport_units")
    public List<TransportUnit> retrieveAllTransportUnits() {
        return transportUnitService.retrieveAllTUs();
    }

}
