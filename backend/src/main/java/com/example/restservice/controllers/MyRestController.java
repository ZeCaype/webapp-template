package com.example.restservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.dtos.EntityDto;
import com.example.restservice.mappers.EntityMapper;
import com.example.restservice.services.LogicService;

@RestController
@CrossOrigin
@RequestMapping(value = "/entity")
public class MyRestController {

	private LogicService logicService;
	private EntityMapper entityMapper;

	/**
	 * Constructor with injected services instances.
	 * 
	 * @param logicService
	 */
	@Autowired
	public MyRestController(LogicService logicService, EntityMapper entityMapper) {
		this.logicService = logicService;
		this.entityMapper = entityMapper;
	}

	/**
	 * Your first endpoint!
	 * @return EntityDto -> Your newly created object!
	 */
	@PostMapping
	public void createAnEntity(@RequestBody EntityDto entityDto) {
		logicService.saveEntity(entityMapper.toDomain(entityDto));
	}

	/**
	 * Your second endpoint!
	 * @return EntityDto -> Your object to return!
	 */
	@GetMapping("/{entityId}")
	public EntityDto getEntity(@PathVariable String entityId) {
		return entityMapper.toDto(logicService.getEntityById(entityId));
	}
	
	/**
	 * Your third endpoint!
	 * @return List of EntityDto
	 */
	@GetMapping
	public List<EntityDto> getAllEntity() {
		return entityMapper.toDtos(logicService.getAllEntities());
	}
}
