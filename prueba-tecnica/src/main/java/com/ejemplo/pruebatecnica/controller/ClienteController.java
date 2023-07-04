package com.ejemplo.pruebatecnica.controller;

import com.ejemplo.pruebatecnica.entity.Cliente;
import com.ejemplo.pruebatecnica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/listclientes")
    public ResponseEntity<List<Cliente>> getClientes() {
        return new ResponseEntity<>(clienteService.getClientes(), HttpStatus.OK);
    }

    @PostMapping(value = "/creacliente")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {
        Map<String, Object> response = new HashMap<>();

        try {
            Cliente respuesta = clienteService.addCliente(cliente);
            return new ResponseEntity(respuesta, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al insertar Cliente en la base de datos");
            response.put("Error", e.getMostSpecificCause().getMessage());

            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/kpideclientes")
    public List<String> kPideClientes (){
        double promedio = clienteService.promedioEdades(clienteService.getClientes());
        double desviacionEstandar = clienteService.desviacionEstandar(clienteService.getClientes(), promedio);

        List<String> operacion = List.of("promedio: "+ promedio, "disvision estandar: "+ desviacionEstandar);
        return operacion;
    }
}
