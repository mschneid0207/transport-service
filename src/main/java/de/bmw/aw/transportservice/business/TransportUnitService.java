package de.bmw.aw.transportservice.business;

import de.bmw.aw.transportservice.data.TransportUnitRepository;
import de.bmw.aw.transportservice.model.TransportUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportUnitService {

    @Autowired
    TransportUnitRepository repository;

    public List<TransportUnit> retrieveAllTUs() {
        return repository.findAll();
    }

    public TransportUnit existTU(TransportUnit transportUnit) {
        TransportUnit tu = repository.findByBarCode(transportUnit.getBarCode());
        if (tu == null) {
            TransportUnit savedTu = repository.save(transportUnit);
            return  savedTu;
        } else {
            return tu;
        }
    }

}
