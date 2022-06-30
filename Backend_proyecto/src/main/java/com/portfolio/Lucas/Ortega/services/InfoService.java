package com.portfolio.Lucas.Ortega.services;

import com.portfolio.Lucas.Ortega.exception.UserNotFoundException;
import com.portfolio.Lucas.Ortega.models.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.Lucas.Ortega.repository.InfoRepo;

import java.util.List;

@Service
@Transactional
public class InfoService {
    private final InfoRepo infoRepo;

    @Autowired
    public InfoService(InfoRepo infoRepo) {
        this.infoRepo = infoRepo;
    }
    public Info addInfo(Info info){
        return infoRepo.save(info);
    }
    public List<Info> findInfo(Long id){
        return infoRepo.findAll();
    }
    public Info editInfo(Info info){
        return infoRepo.save(info);
    }
    public void deleteInfo(Long id){
        infoRepo.deleteById(id);
    }
    public Info findInfoById (Long id){
        return infoRepo.findById(id).orElseThrow(() -> new UserNotFoundException("usuario no encontrado"));
    }
}
