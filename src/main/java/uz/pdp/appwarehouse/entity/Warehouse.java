package uz.pdp.appwarehouse.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.appwarehouse.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode
@Data
@Entity
public class Warehouse extends AbsEntity {
}
