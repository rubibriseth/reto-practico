package com.ejemplo.pruebatecnica.service;

import com.ejemplo.pruebatecnica.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> getClientes();

    Cliente addCliente(Cliente cliente);

    List<Cliente> getEdadesClientes();

    Double promedioEdades(List<Cliente> listClientes);

    Double desviacionEstandar(List<Cliente> listClientes, double promedio);

}
