package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByFirstNameAndLastNameAndWarehouses_id(String firstName, String lastName, Integer warehouses_id);
}
