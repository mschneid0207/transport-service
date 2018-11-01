package de.bmw.aw.transportservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransportUnit {

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
