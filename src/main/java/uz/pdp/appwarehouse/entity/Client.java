package uz.pdp.appwarehouse.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.appwarehouse.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode
@Data
@Entity
public class Client extends AbsEntity {
    @Column(nullable = false,unique = true)
    private String phoneNumber;
}
