package uz.pdp.appwarehouse.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OutputDto {
    private Timestamp data;
    private String factureNumber;
    private String code;
    private Integer warhouseId;
    private Integer clienId;
    private Integer currencyId;
}
