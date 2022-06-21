package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    //boolean existsByName(String name);
}
