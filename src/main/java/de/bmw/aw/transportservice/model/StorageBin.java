package de.bmw.aw.transportservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageBin implements Serializable {

    private Long id;
    private Integer corridor;
    private Integer rack;
    private Integer level;
    private Integer section;
}
