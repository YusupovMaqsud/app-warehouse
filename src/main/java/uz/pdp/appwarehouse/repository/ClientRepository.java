package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.entity.Measurement;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    boolean existsByName(String name);
}
