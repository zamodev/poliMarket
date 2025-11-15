package com.polimarket.Service;

import com.polimarket.Converter.ClienteConverter;
import com.polimarket.DTO.Cliente;
import com.polimarket.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentaServiceImpl implements VentasService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientesPosibles() {
        return ClienteConverter.ClienteConverterListEntityTODTO(clienteRepository.findPosibles());
    }
}
