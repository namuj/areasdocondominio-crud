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
import com.example.crud.areasdocondominio.model.Reserva;
import com.example.crud.areasdocondominio.repository.MoradorRepository;
import com.example.crud.areasdocondominio.repository.ReservaRepository;

@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
public class ReservaController {
	@Autowired
	private ReservaRepository reservaRepository;
	
	@GetMapping("/reservas")
	public List<Reserva> getAllAreas(){
		return reservaRepository.findAll();
	}
	@GetMapping("/reserva/{id}")
	public ResponseEntity<Reserva> getAreasById(@PathVariable(value="id") long id_reserva) throws ResourceNotFoundException{
	
		Reserva reserva= reservaRepository.findById(id_reserva).orElseThrow(()->new ResourceNotFoundException("Reserva não encontrada ::"+ id_reserva));
		return ResponseEntity.ok().body(reserva);
	}
	@PostMapping("/reserva")
	public Reserva createReserva(@Valid @RequestBody Reserva reserva) {
		
		return reservaRepository.save(reserva);
	}
	@PutMapping("/reserva/{id}")
	public ResponseEntity<Reserva> updateReserva(@PathVariable(value="id") long id_reserva,@Valid @RequestBody Reserva reservaDetails) throws ResourceNotFoundException{
		
		Reserva reserva = reservaRepository.findById(id_reserva).orElseThrow(()->new ResourceNotFoundException("Nenhuma Reserva encontrada para esse ID::"+id_reserva));
	/*reserva.setMorador(reservaDetails.getMorador());
		reserva.setData(reservaDetails.getData());
		reserva.setHora_inicio(reservaDetails.getHora_inicio());
		reserva.setHora_fim(reservaDetails.getHora_fim());
		*/
		final Reserva updateReserva = reservaRepository.save(reserva);
		
		return ResponseEntity.ok(updateReserva);
		
	}
	@DeleteMapping("/reserva/{id}")
	public Map<String,Boolean> deleteReserva(@PathVariable(value="id") long id_reserva) throws ResourceNotFoundException{
		Reserva reserva = reservaRepository.findById(id_reserva).orElseThrow(()->new ResourceNotFoundException("Nenhuma Reserva encontrada para esse ID::"+id_reserva));
		reservaRepository.delete(reserva);
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		
		return response;
	}
}
