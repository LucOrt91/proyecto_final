package com.portfolio.Lucas.Ortega.Security.service;

import java.util.Optional;
import javax.transaction.Transactional;

import com.portfolio.Lucas.Ortega.Security.entity.Rol;
import com.portfolio.Lucas.Ortega.Security.enums.RolNombre;
import com.portfolio.Lucas.Ortega.Security.repository.iRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
