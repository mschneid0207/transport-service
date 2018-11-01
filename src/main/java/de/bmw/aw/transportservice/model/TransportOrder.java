package de.bmw.aw.transportservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransportOrder {

    @Id
    @GeneratedValue
    private Integer id;
    private String barCode;
    private Integer location;
    private Integer target;

}
