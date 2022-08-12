package com.portfolio.Lucas.Ortega.Repository;



import com.portfolio.Lucas.Ortega.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RProyecto extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByNombrePro(String nombrePro);
    public boolean existsByNombrePro(String nombrePro);

}
