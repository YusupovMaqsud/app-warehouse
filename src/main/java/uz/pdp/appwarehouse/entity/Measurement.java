package uz.pdp.appwarehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appwarehouse.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode
@Data
@Entity
public class Measurement extends AbsEntity {
}
