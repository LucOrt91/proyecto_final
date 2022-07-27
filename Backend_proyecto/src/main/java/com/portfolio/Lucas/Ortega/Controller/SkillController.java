package com.lucasnortegaportfolio.lucas.n.ortega.Controller;

import com.lucasnortegaportfolio.lucas.n.ortega.Entity.Skill;
import com.lucasnortegaportfolio.lucas.n.ortega.Interface.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SkillController {

    @Autowired
    ISkillService iSkillService;

    @GetMapping("/skills/traer")
    public List<Skill> getSkill(){
        return iSkillService.getSkill();
    }

    @PostMapping("/skills/crear")
    public String createSkill(@RequestBody Skill skill){
        iSkillService.saveSkill(skill);
        return "La skill fue creada correctamente";
    }
    @DeleteMapping("/skills/borrar/{id}")
    public String deleteSkill(@PathVariable Long id){
        iSkillService.deleteSkill(id);
        return "La skill fue eliminada correctamente";
    }
    @PutMapping("/skills/editar/{id}")
    public Skill editSkill(@PathVariable Long id,
                           @RequestParam("nombre") String nuevoNombre,
                           @RequestParam("porcentaje") int nuevoPorcentaje,
                           @RequestParam("img") String nuevoImg){
        Skill skill = iSkillService.findSkill(id);
        skill.setNombreSkill(nuevoNombre);
        skill.setPorcentaje(nuevoPorcentaje);
        skill.setImgSkill(nuevoImg);

        iSkillService.saveSkill(skill);
        return skill;
    }

}