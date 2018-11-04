package de.bmw.aw.transportservice.rest;

import de.bmw.aw.transportservice.business.TransportOrderService;
import de.bmw.aw.transportservice.business.TransportUnitService;
import de.bmw.aw.transportservice.model.TransportOrder;
import de.bmw.aw.transportservice.model.TransportUnit;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TransportOrderController {

    @Autowired
    private TransportUnitService transportUnitService;

    @Autowired
    private TransportOrderService transportOrderService;


    @PostMapping("/transport_order")
    @ApiOperation(value = "creates new transport order")
    public TransportOrder createTransportOrder(@RequestBody TransportUnit transportUnit) {
        // TODO response with correct http status

        TransportOrder transportOrder = transportOrderService.createTransportOrder(transportUnit);
        //return new ResponseEntity(transportOrder, HttpStatus.CREATED);
        return transportOrder;
    }

    @PostMapping("/transport_order_with_rabbitmq")
    @ApiOperation(value = "creates new transport order via rabbitmq")
    public ResponseEntity createTransportOrderRabbitMq(@RequestBody TransportUnit transportUnit) {

        transportOrderService.createTransportOrderByRabbitMq(transportUnit);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/transport_units")
    @ApiOperation(value = "retrieves all transport units")
    public List<TransportUnit> retrieveAllTransportUnits() {
        return transportUnitService.retrieveAllTUs();
    }

}
