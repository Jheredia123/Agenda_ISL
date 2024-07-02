package com.geos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geos.entity.Empleador;
import com.geos.repository.IEmpleadorRepository;

@Service
public class EmpleadorServiceImpl implements IEmpleadorService{
	

    @Autowired
    private IEmpleadorRepository empleadorRepository;

    @Override
    public List<Empleador> getAllEmpleadores() {
        return empleadorRepository.findAll();
    }

    @Override
    public Optional<Empleador> getEmpleadorById(Integer id) {
        return empleadorRepository.findById(id);
    }
    
    @Override
    public Empleador buscarPorRut(String rut) {
        return empleadorRepository.findByRut(rut);
    }

    @Override
    public Empleador createEmpleador(Empleador empleador) {
        return empleadorRepository.save(empleador);
    }

    @Override
    public Empleador updateEmpleador(Integer id, Empleador empleadorDetails) {
        return empleadorRepository.findById(id).map(empleador -> {
            empleador.setRut(empleadorDetails.getRut());
            empleador.setRazonSocial(empleadorDetails.getRazonSocial());
            empleador.setContacto(empleadorDetails.getContacto());
            empleador.setFono(empleadorDetails.getFono());
            empleador.setCorreo(empleadorDetails.getCorreo());
            empleador.setTipo(empleadorDetails.getTipo());
            empleador.setEstado(empleadorDetails.getEstado());
            return empleadorRepository.save(empleador);
        }).orElseThrow(() -> new RuntimeException("Empleador not found with id " + id));
    }

    @Override
    public void deleteEmpleador(Integer id) {
        Empleador empleador = empleadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleador not found with id " + id));
        empleadorRepository.delete(empleador);
    }

}
