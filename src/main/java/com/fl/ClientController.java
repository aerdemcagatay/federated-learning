package com.fl;

import com.fl.persistence.ClientRepository;
import com.fl.pojo.Client;
import com.fl.requests.EnrollRequest;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ClientController {

    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/clients")
    List<Client> all() {
        return repository.findAll();
    }

    @PostMapping("/enroll")
    Client newClient(@RequestBody EnrollRequest enrollRequest) {
        return repository.save(new Client(enrollRequest.getName()));
    }

    @GetMapping("/clients/{id}")
    Client one(@PathVariable String id) {

        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid)
                .orElseThrow(() -> new ClientNotFoundException(uuid));
    }

    @GetMapping("/healthcheck")
    Map healthCheck() {
        return Collections.singletonMap("Status", "alive");
    }






}
