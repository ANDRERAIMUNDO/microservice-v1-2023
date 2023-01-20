package com.arct.hrworker.resources;

import com.arct.hrworker.entities.Work;
import com.arct.hrworker.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkResources {

    @Autowired
    private WorkRepository repository;

    @GetMapping
    public ResponseEntity <List<Work>> findAll() {
        List<Work> list = repository.findAll();
        return  ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Work> findId (@PathVariable Long id) {
        Work obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
