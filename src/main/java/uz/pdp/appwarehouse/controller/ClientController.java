package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.ClientService;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/addclient")
    public Result addClient(@RequestBody Client client) {
        Result result = clientService.addClient(client);
        return result;
    }


    @GetMapping("/getclients")
    public List<Client> getClients(List<Client> clients) {
        List<Client> clientList = clientService.getClients(clients);
        return clientList;
    }

    @GetMapping("/getclient/{id}")
    public Result getClient(@PathVariable Integer id) {
        Result client = clientService.getClient(id);
        return client;
    }

    @DeleteMapping("/deleteclient/{id}")
    public Result deleteClient(@PathVariable Integer id) {
        Result result = clientService.deleteClient(id);
        return result;
    }


    @PutMapping("/editclient/{id}")
    public Result editClient(@RequestBody Client client, Integer id) {
        Result result = clientService.editClient(client, id);
        return result;
    }

}
