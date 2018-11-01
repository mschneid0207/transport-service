package de.bmw.aw.transportservice.data;

import de.bmw.aw.transportservice.model.TransportUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TransportUnitRepositoryTest {

    @Autowired
    private TransportUnitRepository sut;

    @Test
    public void findByBarCode() {
        assertNotNull(sut.findByBarCode("bar_code1"));
    }

    @Test
    public void findByBarCodeQuery() {
        assertNotNull(sut.findByBarCodeQuery("bar_code1"));
    }

    @Test
    public void findAllTransportUnitsQuery() {
        assertEquals(3, sut.findAllTransportUnitsQuery().size());
    }

}