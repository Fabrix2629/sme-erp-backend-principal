package proy.backend.proyClients.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proy.backend.proyClients.dto.SmClienteDto;
import proy.backend.proyClients.entity.SmCliente;
import proy.backend.proyClients.service.SmClienteService;
@CrossOrigin
@RequestMapping("/api/clientes")
@RestController
@PreAuthorize("dennyAll()")
public class SmClienteController {

    private final SmClienteService smClienteService;

    public SmClienteController(SmClienteService smClienteService) {
        this.smClienteService = smClienteService;
    }

    // GET - LISTAR TODOS LOS CLIENTES
    @GetMapping
    @PreAuthorize("hasAuthority('UPDATE') or hasAuthority('READ') or hasAuthority('DELETE') or hasAuthority('CREATE')")
    ResponseEntity<Iterable<SmCliente>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(smClienteService.findAll());
    }

    // GET - BUSCAR POR ID DEL CLIENTE
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE') or hasAuthority('READ') or hasAuthority('DELETE') or hasAuthority('CREATE')")
    public ResponseEntity<SmCliente> get(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(smClienteService.findById(id));
    }


    @PostMapping
    @PreAuthorize("hasAuthority('UPDATE') or hasAuthority('READ') or hasAuthority('DELETE') or hasAuthority('CREATE')")
    public ResponseEntity<SmCliente> createCliente(@RequestBody @Valid SmClienteDto clienteDto) {
        SmCliente nuevoCliente = smClienteService.createCliente(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    // PUT - ACTUALIZAR CLIENTE POR ID
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE') or hasAuthority('READ') or hasAuthority('DELETE') or hasAuthority('CREATE')")
    public ResponseEntity<SmCliente> updateCliente(@PathVariable Integer id, @RequestBody @Valid SmClienteDto clienteDto) {
        SmCliente clienteActualizado = smClienteService.updateCliente(id, clienteDto);
        return ResponseEntity.ok(clienteActualizado);
    }

    // DETELE - ELIMINAR CLIENTE POR ID
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('UPDATE') or hasAuthority('READ') or hasAuthority('DELETE') or hasAuthority('CREATE')")
    public void delete(@PathVariable Integer id){
        smClienteService.delete(id);
    }

}
