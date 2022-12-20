package org.spring.foto.service;

import java.util.List;

import org.spring.foto.pojo.Role;
import org.spring.foto.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	
//  Find all
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

//  Find by Id
	public Role getById(int id) {
		return roleRepo.findById(id).get();
	}
	
//  Save
	public void save(Role role) {			
		roleRepo.save(role);
	}
	
//  Delete
	public void delete(Role role) {
		roleRepo.delete(role);
	}
	
//  Delete by ID
	public void deleteById(int id) {
		roleRepo.deleteById(id);
	}
}
