package com.example.restservice.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.domain.Entity;
import com.example.restservice.dtos.EntityDto;

@Component
public class EntityMapper {

	@Autowired
	public EntityMapper() {
		
	}

	public EntityDto toDto(Entity entity) {
		EntityDto dto = new EntityDto();
		dto.id = entity.getId();
		dto.type = entity.getType();
		dto.color = entity.getColor();
		
		return dto;
	}
	
	public Entity toDomain(EntityDto entityDto) {
		Entity entity = new Entity();
		entity.setId(entityDto.id);
		entity.setType(entityDto.type);
		entity.setColor(entityDto.color);
		
		return entity;
	}

	public List<EntityDto> toDtos(Collection<Entity> allEntities) {
		List<EntityDto> allEntitiesDtos = new ArrayList<EntityDto>();
		
		for(Entity entity : allEntities) {
			allEntitiesDtos.add(this.toDto(entity));
		}
		
		return allEntitiesDtos;
	}
}
