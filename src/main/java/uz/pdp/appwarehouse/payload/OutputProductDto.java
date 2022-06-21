package uz.pdp.appwarehouse.payload;

import lombok.Data;

import java.sql.Date;

@Data
public class OutputProductDto {
    private Double amount;
    private Double price;
    private Integer productId;
    private Integer outputId;
}
