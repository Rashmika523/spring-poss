package com.iitposs.pos.dto.response;

import com.iitposs.pos.util.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemResponseDTO {

    private String itemName;
    private MeasuringType measuringType;
    private double supplierPrice;
    private double displayPrice;
    private double sellingPrice;
    private int qtyOnHand;

}
