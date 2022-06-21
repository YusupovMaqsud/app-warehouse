package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.Product;

public interface InputRepository extends JpaRepository<Input,Integer> {
    boolean existsByCode(String code);
}
