package com.example.crud.areasdocondominio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.example.crud.areasdocondominio.exception.ResourceNotFoundException;
import com.example.crud.areasdocondominio.model.Areas;
import com.example.crud.areasdocondominio.model.Morador;
import com.example.crud.areasdocondominio.repository.AreasRepository;
import com.example.crud.areasdocondominio.repository.MoradorRepository;

@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
public class MoradorController {
	@Autowired
	private MoradorRepository moradorRepository;
	
	@GetMapping("/morador")
	public List<Morador> getAllAreas(){
		return moradorRepository.findAll();
	}
	
	@GetMapping("/morador/{id}")
	public ResponseEntity<Morador> getAreasById(@PathVariable(value="id") long id_morador) throws ResourceNotFoundException{
	
		Morador morador= moradorRepository.findById(id_morador).orElseThrow(()->new ResourceNotFoundException("Morador não encontrado ::"+ id_morador));
		return ResponseEntity.ok().body(morador);
	}
	@PostMapping("/morador")
	public Morador createMorador(@Valid @RequestBody Morador morador) {
		return moradorRepository.save(morador);
	}
	@PutMapping("/morador/{id}")
	public ResponseEntity<Morador> updateAreas(@PathVariable(value="id") long id_morador,@Valid @RequestBody Morador moradorDetails) throws ResourceNotFoundException{
		
		Morador morador = moradorRepository.findById(id_morador).orElseThrow(()->new ResourceNotFoundException("Nenhum Morador encontrado para esse ID::"+id_morador));
		morador.setNome_morador(moradorDetails.getNome_morador());
		morador.setApartamento(moradorDetails.getApartamento());
		morador.setCpf(moradorDetails.getCpf());
		morador.setNome_edificio(moradorDetails.getNome_edificio());
		
		final Morador updateMorador =moradorRepository.save(morador);
		
		return ResponseEntity.ok(updateMorador);
		
	}
	@DeleteMapping("/morador/{id}")
	public Map<String,Boolean> deleteMorador(@PathVariable(value="id") long id_morador) throws ResourceNotFoundException{
		Morador morador = moradorRepository.findById(id_morador).orElseThrow(()->new ResourceNotFoundException("Nenhum Morador encontrado para esse ID::"+id_morador));
		moradorRepository.delete(morador);
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		
		return response;
	}
	
	
}
