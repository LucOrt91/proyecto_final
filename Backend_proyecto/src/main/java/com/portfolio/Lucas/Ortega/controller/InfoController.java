package com.portfolio.Lucas.Ortega.controller;

import com.portfolio.Lucas.Ortega.models.Info;
import com.portfolio.Lucas.Ortega.services.InfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/info")
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Info> getInfo(@PathVariable("id") Long id){
        Info info = infoService.findInfoById(id);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Info> editInfo(@RequestBody Info info){
        Info updateInfo = infoService.editInfo(info);
        return new ResponseEntity<>(updateInfo, HttpStatus.OK);
    }
}
