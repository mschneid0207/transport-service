package de.bmw.aw.transportservice.data;

import de.bmw.aw.transportservice.model.TransportUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportUnitRepository extends JpaRepository<TransportUnit, Integer> {

    TransportUnit findByBarCode(String barCode);

    @Query("select t from TransportUnit t where t.barCode = :barCode")
    TransportUnit findByBarCodeQuery(@Param("barCode") String barCode);

    @Query("select t from TransportUnit t")
    List<TransportUnit> findAllTransportUnitsQuery();


}
