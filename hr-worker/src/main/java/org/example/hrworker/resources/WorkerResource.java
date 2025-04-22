package org.example.hrworker.resources;

import javassist.NotFoundException;
import org.example.hrworker.entities.Worker;
import org.example.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> buscarTodos(){
        List<Worker> workers = workerRepository.findAll();

        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> buscarPorId(@PathVariable Long id) throws NotFoundException {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Worker não encontrado"));

        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

}
