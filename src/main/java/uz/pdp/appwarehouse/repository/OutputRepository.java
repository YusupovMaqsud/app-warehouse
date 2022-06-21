package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.Output;

public interface OutputRepository extends JpaRepository<Output,Integer> {
    boolean existsByCode(String code);
}
