package proy.backend.proyClients.controller;

import org.springframework.web.bind.annotation.*;
import proy.backend.proyClients.entity.SmDocumento;
import proy.backend.proyClients.service.SmDocumentoService;

@CrossOrigin
@RequestMapping("/api/documentos")
@RestController
public class SmDocumentoController {

    private final SmDocumentoService smDocumentoService;

    public SmDocumentoController(SmDocumentoService smDocumentoService) {
        this.smDocumentoService = smDocumentoService;
    }

    @GetMapping
    Iterable<SmDocumento> list() {
        return smDocumentoService.findAll();
    }

    @GetMapping("/{id}")
    public SmDocumento get(@PathVariable Integer id){
        return smDocumentoService.findById(id);
    }

}
