package proy.backend.proyClients.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proy.backend.proyClients.dto.SmClienteDto;
import proy.backend.proyClients.dto.SmDocumentoDto;
import proy.backend.proyClients.entity.SmCliente;

import proy.backend.proyClients.entity.SmContribuyente;
import proy.backend.proyClients.entity.SmDocumento;
import proy.backend.proyClients.exception.ResourceNotFoundException;
import proy.backend.proyClients.repository.SmClienteRepository;
import proy.backend.proyClients.repository.SmContribuyenteRepository;
import proy.backend.proyClients.repository.SmDocumentoRepository;

@Service
public class SmClienteService {

    @Autowired
    private SmClienteRepository smClienteRepository;
    @Autowired
    private SmDocumentoRepository smDocumentoRepository;
    @Autowired
    private SmContribuyenteRepository smContribuyenteRepository;

    public SmClienteService(SmClienteRepository clienteRepository,
                            SmDocumentoRepository documentoRepository,
                            SmContribuyenteRepository contribuyenteRepository) {
        this.smClienteRepository = clienteRepository;
        this.smDocumentoRepository = documentoRepository;
        this.smContribuyenteRepository = contribuyenteRepository;
    }

    public Iterable<SmCliente> findAll() {
        return smClienteRepository.findAll();
    }

    public SmCliente findById(Integer id){
        return smClienteRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException:: new);
    }

    public SmCliente createCliente(SmClienteDto clienteDto) {
        SmDocumento documento = smDocumentoRepository.findById(clienteDto.getTipoDocumento().getIdTipoDocumento()).orElse(null);
        SmContribuyente contribuyente = smContribuyenteRepository.findById(clienteDto.getTipoContribuyente().getIdTipoContribuyente()).orElse(null);
        SmCliente cliente = new SmCliente();

        //cliente.setIdEntidad(clienteDto.getIdEntidad());
        cliente.setNroDocumento(clienteDto.getNroDocumento());
        cliente.setRazonSocial(clienteDto.getRazonSocial());
        cliente.setNombreComercial(clienteDto.getNombreComercial());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setEstado(clienteDto.getEstado());
        cliente.setTipoDocumento(documento);
        cliente.setTipoContribuyente(contribuyente);

        return smClienteRepository.save(cliente);
    }
    public SmCliente updateCliente(Integer id, SmClienteDto clienteDto) {

        SmCliente cliente = smClienteRepository.findById(id).orElse(null);

        if (clienteDto.getTipoDocumento().getIdTipoDocumento() != null) {
            SmDocumento documento = smDocumentoRepository.findById(clienteDto.getTipoDocumento().getIdTipoDocumento()).orElse(null);
            cliente.setTipoDocumento(documento);
        }

        if (clienteDto.getTipoContribuyente().getIdTipoContribuyente() != null) {
            SmContribuyente contribuyente = smContribuyenteRepository.findById(clienteDto.getTipoContribuyente().getIdTipoContribuyente()).orElse(null);
            cliente.setTipoContribuyente(contribuyente);
        }

        cliente.setNroDocumento(clienteDto.getNroDocumento() != null ? clienteDto.getNroDocumento() : cliente.getNroDocumento());
        cliente.setRazonSocial(clienteDto.getRazonSocial() != null ? clienteDto.getRazonSocial() : cliente.getRazonSocial());
        cliente.setNombreComercial(clienteDto.getNombreComercial() != null ? clienteDto.getNombreComercial() : cliente.getNombreComercial());
        cliente.setDireccion(clienteDto.getDireccion() != null ? clienteDto.getDireccion() : cliente.getDireccion());
        cliente.setTelefono(clienteDto.getTelefono() != null ? clienteDto.getTelefono() : cliente.getTelefono());
        cliente.setEstado(clienteDto.getEstado() != null ? clienteDto.getEstado() : cliente.getEstado());

        return smClienteRepository.save(cliente);
    }

    public void delete(Integer id){
        SmCliente clientebody = findById(id);
        smClienteRepository.delete(clientebody);
    }
}
