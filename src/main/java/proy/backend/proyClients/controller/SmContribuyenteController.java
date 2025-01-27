package proy.backend.proyClients.controller;

import org.springframework.web.bind.annotation.*;
import proy.backend.proyClients.entity.SmContribuyente;
import proy.backend.proyClients.entity.SmDocumento;
import proy.backend.proyClients.service.SmContribuyenteService;

@CrossOrigin
@RequestMapping("/api/contribuyentes")
@RestController
public class SmContribuyenteController {

    private final SmContribuyenteService smContribuyenteService;

    public SmContribuyenteController(SmContribuyenteService smContribuyenteService) {
        this.smContribuyenteService = smContribuyenteService;
    }

    @GetMapping
    Iterable<SmContribuyente> list() {
        return smContribuyenteService.findAll();
    }

    @GetMapping("/{id}")
    public SmContribuyente get(@PathVariable Integer id){
        return smContribuyenteService.findById(id);
    }

}
