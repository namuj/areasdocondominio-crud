package com.example.crud.areasdocondominio.controller;

import com.example.crud.areasdocondominio.exception.ResourceNotFoundException;
import com.example.crud.areasdocondominio.model.Areas;
import com.example.crud.areasdocondominio.repository.AreasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;





@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
public class AreasController {
	
	@Autowired
	private AreasRepository areasRepository;
	
	@GetMapping("/areas")
	public List<Areas> getAllAreas(){
		return areasRepository.findAll();
	}
	@GetMapping("/areas/{id}")
	public ResponseEntity<Areas> getAreasById(@PathVariable(value="id") long areasId) throws ResourceNotFoundException{
	
		Areas areas= areasRepository.findById(areasId).orElseThrow(()->new ResourceNotFoundException("Area não encontrada ::"+ areasId));
		return ResponseEntity.ok().body(areas);
	}
	@PostMapping("/areas")
	public Areas createAreas(@Valid @RequestBody Areas areas) {
		return areasRepository.save(areas);
	}
	
	@PutMapping("/areas/{id}")
	public ResponseEntity<Areas> updateAreas(@PathVariable(value="id") long areasId,@Valid @RequestBody Areas areasDetails) throws ResourceNotFoundException{
		
		Areas areas = areasRepository.findById(areasId).orElseThrow(()->new ResourceNotFoundException("Nenhuma Area encontrada para esse ID::"+areasId));
		areas.setNome(areasDetails.getNome());
		
		
		final Areas updateAreas =areasRepository.save(areas);
		
		return ResponseEntity.ok(updateAreas);
		
	}
	
	@DeleteMapping("/areas/{id}")
	public Map<String,Boolean> deleteAreas(@PathVariable(value="id") long areasId) throws ResourceNotFoundException{
		Areas areas = areasRepository.findById(areasId).orElseThrow(()->new ResourceNotFoundException("Nenhuma Area encontrada para esse ID::"+areasId));
		areasRepository.delete(areas);
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		
		return response;
	}
}


