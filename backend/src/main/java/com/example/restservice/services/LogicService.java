package com.example.restservice.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.domain.Entity;

@Component
public class LogicService {

	private Map<String, Entity> entityDatabase;

	@Autowired
	public LogicService() {
		entityDatabase = new HashMap<String, Entity>();
		
		String id = UUID.randomUUID().toString();
		entityDatabase.put(id, new Entity(id, "Boat", "Yellow"));
		
		String idb = UUID.randomUUID().toString();
		entityDatabase.put(idb, new Entity(idb, "Car", "Violet"));
		
		String idc = UUID.randomUUID().toString();
		entityDatabase.put(idc, new Entity(idc, "Plane", "Red"));
	}

	public void saveEntity(Entity entity) {
		this.entityDatabase.put(entity.getId(), entity);
	}

	public Entity getEntityById(String entityId) {
		return this.entityDatabase.get(entityId);
	}

	public Map<String, Entity> getEntityDatabase() {
		return entityDatabase;
	}

	public Collection<Entity> getAllEntities() {
		return this.entityDatabase.values();
	}

}
