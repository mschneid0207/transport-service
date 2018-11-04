package de.bmw.aw.transportservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransportUnit implements Serializable {

    public enum TransportType {
        SMALL, MEDIUM, BIG;
    }

    @Id
    @GeneratedValue
    private Integer id;
    private String barCode;
    @Enumerated(EnumType.STRING)
    private TransportType transportType;
}
