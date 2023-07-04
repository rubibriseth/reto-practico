package com.ejemplo.pruebatecnica.service.impl;

import com.ejemplo.pruebatecnica.entity.Cliente;
import com.ejemplo.pruebatecnica.repository.ClienteDAO;
import com.ejemplo.pruebatecnica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public List<Cliente> getClientes() {
        return clienteDAO.findAll();
    }

    @Override
    public Cliente addCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Double promedioEdades(List<Cliente> listClientes) {

        //List<Integer> listaEdades = listClientes.stream().map(c -> c.getEdad()).collect(Collectors.toList());
        double sumaEdades = listClientes.stream().mapToDouble(v -> v.getEdad()).sum();

        double promedio =  sumaEdades / listClientes.size();

        //System.out.println("promedio: " + promedio);
        return Double.isNaN(promedio)? 0 : promedio;
    }

    @Override
    public Double desviacionEstandar(List<Cliente> listClientes, double promedio) {
        double sumatoria = listClientes.stream()
                .mapToDouble(v -> Math.pow(v.getEdad() - promedio, 2)).sum();

        double desviacionEstandar = Math.sqrt(sumatoria / listClientes.size());

        //System.out.println("Desviación estándar: " + desviacionEstandar);
        return Double.isNaN(desviacionEstandar)? 0 :desviacionEstandar;
    }
}
