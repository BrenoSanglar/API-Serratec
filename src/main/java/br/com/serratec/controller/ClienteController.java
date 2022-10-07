package br.com.serratec.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.model.Cliente;
import br.com.serratec.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}

	@GetMapping("{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrar(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@PostMapping("/cadastrarVarios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Cliente> cadastrarVarios(@Valid @RequestBody List<Cliente> cliente) {
		return clienteRepository.saveAll(cliente);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Cliente> deletar(@PathVariable Long id){
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("{id}")
    public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            cliente = clienteRepository.save(cliente);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
