package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.ClientRepository;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Result addClient(Client client) {
        boolean exists = clientRepository.existsByName(client.getName());
        if (exists)
            return new Result("Bunday client mavjud", false);

        clientRepository.save(client);

        return new Result("Muvaffaqiyatli saqlandi", true);
    }


    public List<Client> getClients(List<Client> clients) {
        List<Client> clientList = clientRepository.findAll();
        return clientList;
    }


    public Result getClient(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent())
            return new Result("Client mavjud emas", false);

        Client client = optionalClient.get();
        return new Result("Client mavjud", true, client);
    }


    public Result deleteClient(Integer id) {
        clientRepository.deleteById(id);
        return new Result("Client deleted", true);
    }


    public Result editClient(Client clients, Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent())
            return new Result("Client mavjud emas", false);
        Client client = optionalClient.get();
        client.setName(clients.getName());
        client.setPhoneNumber(clients.getPhoneNumber());
        return new Result("Client edited", true);
    }
}
