package de.bmw.aw.transportservice.business;

import de.bmw.aw.transportservice.data.TransportOrderRepository;
import de.bmw.aw.transportservice.model.StorageBin;
import de.bmw.aw.transportservice.model.TransportOrder;
import de.bmw.aw.transportservice.model.TransportUnit;
import de.bmw.aw.transportservice.proxy.StorageBinServiceProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransportOrderServiceTest {

    @InjectMocks
    private TransportOrderService sut;

    @Mock
    private TransportUnitService transportUnitServiceMock;

    @Mock
    private TransportOrderRepository transportOrderRepositoryMock;

    @Mock
    private StorageBinServiceProxy storageBinServiceProxyMock;

    private ArgumentCaptor<TransportOrder> transportOrderCaptor = ArgumentCaptor.forClass(TransportOrder.class);

    @Test
    public void createTransportOrder() {
        TransportUnit expectedTransportUnit = TransportUnit.builder()
                .id(100)
                .barCode("barCode")
                .transportType(TransportUnit.TransportType.SMALL)
                .build();
        StorageBin expectedStorageBin = StorageBin.builder()
                .id(new Long(10))
                .corridor(1)
                .rack(1)
                .level(1)
                .section(11)
                .build();
        when(transportUnitServiceMock.existTU(expectedTransportUnit)).thenReturn(expectedTransportUnit);
        when(storageBinServiceProxyMock.findFreeStorageBin()).thenReturn(expectedStorageBin);
        sut.createTransportOrder(expectedTransportUnit);

        verify(transportOrderRepositoryMock).save(transportOrderCaptor.capture());

        assertEquals("barCode", transportOrderCaptor.getValue().getBarCode());
        assertEquals(10, (long) transportOrderCaptor.getValue().getTarget());
    }

}