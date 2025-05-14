package org.example.hrworker.resources;

import javassist.NotFoundException;
import org.example.hrworker.entities.Worker;
import org.example.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    //Imprime coisas no Log
    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    //Possuí informações sobre o contexto da aplicação
    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> buscarConfiguracoes() {
        logger.info("config = " + testConfig);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Worker>> buscarTodos() {
        List<Worker> workers = workerRepository.findAll();

        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> buscarPorId(@PathVariable Long id) throws NotFoundException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Worker não encontrado"));

        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

}
