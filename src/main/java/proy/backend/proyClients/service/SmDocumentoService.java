package proy.backend.proyClients.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proy.backend.proyClients.entity.SmDocumento;
import proy.backend.proyClients.repository.SmDocumentoRepository;
@Service
public class SmDocumentoService {
    @Autowired
    private  SmDocumentoRepository smDocumentoRepository;

    public Iterable<SmDocumento> findAll() {
        return smDocumentoRepository.findAll();
    }

    public SmDocumento findById(Integer id){
        return smDocumentoRepository.findById(id).orElse(null);
    }
}
