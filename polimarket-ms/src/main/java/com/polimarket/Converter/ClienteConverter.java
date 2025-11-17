package com.polimarket.Converter;

import com.polimarket.DTO.Cliente;
import com.polimarket.entity.ClienteEntity;

import java.util.ArrayList;
import java.util.List;

public class ClienteConverter {

    public static Cliente ClienteConverterEntityTODTO(ClienteEntity cliente)
    {
        return Cliente.builder()
                .email(cliente.getEmail())
                .nombre(cliente.getNombre())
                .id(cliente.getId())
                .build();
    }

    public static List<Cliente> ClienteConverterListEntityTODTO(List<ClienteEntity> cliente)
    {
        List<Cliente> clientes = new ArrayList<>();
        for(ClienteEntity c:cliente)
        {
            clientes.add(ClienteConverterEntityTODTO(c));
        }
        return clientes;
    }


    public static ClienteEntity ClienteConverterTOEntity(Cliente cliente)
    {
        return ClienteEntity.builder()
                .email(cliente.getEmail())
                .nombre(cliente.getNombre())
                .esPotencial(true)
                .build();
    }
}
