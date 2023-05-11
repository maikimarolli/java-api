package com.leaf.satellite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.leaf.satellite.model.Field;
import com.leaf.satellite.repository.FieldRepository;

@RestController
@RequestMapping("/fields")
public class FieldController {

	@Autowired
	private FieldRepository fieldRepository;
	
	@GetMapping
	public List<Field> getFields() {
		return fieldRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Field getField(@PathVariable Long id) {
		System.out.println(id);
		return fieldRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public Field salvarGeometria(@Validated @RequestBody Field field) {
        return fieldRepository.save(field);
    }
}
