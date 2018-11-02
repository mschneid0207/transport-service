package de.bmw.aw.storagebinservice.business;

import de.bmw.aw.transportservice.business.TransportUnitService;
import de.bmw.aw.transportservice.data.TransportUnitRepository;
import de.bmw.aw.transportservice.model.TransportUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TransportUnitServiceTest {

    @InjectMocks
    private TransportUnitService sut;

    @Mock
    private TransportUnitRepository transportUnitRepositoryMock;

    @Test
    public void tuAlreadyExists() {
        sut.existTU(TransportUnit.builder().barCode("barCode1").build());

        Mockito.verify(transportUnitRepositoryMock, Mockito.times(1)).findByBarCode("barCode1");
    }

    @Test
    public void tuNotExists() {
        TransportUnit tu = TransportUnit.builder().barCode("barCode1").transportType(TransportUnit.TransportType.SMALL).build();
        Mockito.when(transportUnitRepositoryMock.findByBarCode(Mockito.anyString())).thenReturn(null);
        sut.existTU(tu);

        Mockito.verify(transportUnitRepositoryMock, Mockito.times(1)).findByBarCode("barCode1");
        Mockito.verify(transportUnitRepositoryMock, Mockito.times(1)).save(tu);
    }

}