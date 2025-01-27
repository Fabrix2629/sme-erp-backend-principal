package proy.backend.proyClients.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proy.backend.proyClients.entity.SmCliente;
import proy.backend.proyClients.entity.SmContribuyente;
import proy.backend.proyClients.repository.SmContribuyenteRepository;
@Service
public class SmContribuyenteService {
    @Autowired
    private SmContribuyenteRepository smContribuyenteRepository;

    public Iterable<SmContribuyente> findAll() {
        return smContribuyenteRepository.findAll();
    }

    public SmContribuyente findById(Integer id){
        return smContribuyenteRepository
                .findById(id)
                .orElse(null);
    }
}
