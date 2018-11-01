package de.bmw.aw.transportservice.data;

import de.bmw.aw.transportservice.model.TransportOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportOrderRepository extends JpaRepository<TransportOrder,Integer> {
}
