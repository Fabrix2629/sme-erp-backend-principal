package proy.backend.proyClients.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import proy.backend.proyClients.entity.SmCliente;
import proy.backend.proyClients.exception.ResourceNotFoundException;
import proy.backend.proyClients.repository.SmClienteRepository;

import java.util.Optional;

public class SmClienteServiceTest {

    @Mock
    private SmClienteRepository smClienteRepository;

    @InjectMocks
    private SmClienteService smClienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testFindById_Success() {
        // Arrange
        Integer id = 1;
        SmCliente mockCliente = new SmCliente();
        mockCliente.setIdEntidad(id);
        when(smClienteRepository.findById(id)).thenReturn(Optional.of(mockCliente));

        // Act
        SmCliente result = smClienteService.findById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getIdEntidad());
        verify(smClienteRepository, times(1)).findById(id);
    }

    @Test
    void testFindById_ResourceNotFoundException() {
        // Arrange
        Integer id = 1;
        when(smClienteRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> smClienteService.findById(id));
        verify(smClienteRepository, times(1)).findById(id);
    }
}
