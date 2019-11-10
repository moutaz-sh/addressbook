package com.syriatel.bpm.springtest.controllers;

import com.syriatel.bpm.springtest.entity.Role;
import com.syriatel.bpm.springtest.entity.Section;
import com.syriatel.bpm.springtest.repo.Sections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class SectionController {
    @Autowired
    private Sections sections;

    @GetMapping("/section")
    public List<Section> getAllSections(){
        List<Section> allSection =sections.findAll();
        return allSection;
    }
    @PostMapping("/section/add")
    public Section addSection(@RequestBody Section section){
        return sections.save(section);
    }
    @GetMapping("/section/{id}")
    public ResponseEntity<Section> getSection(@PathVariable(value = "id") Long id){
        Optional<Section> temp=sections.findById(id);
        Section sec=temp.get();
        if(sec==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(sec);
        }
    }
    @PutMapping("/section/update/{id}")
    public ResponseEntity<Section> updateSection(@PathVariable(value = "id") Long id,@RequestBody Section se){
        Optional<Section> temp=sections.findById(id);
        Section sec=temp.get();
        if(sec==null){
            return ResponseEntity.notFound().build();
        }else{
            sec.setName(se.getName());
            Section sect=sections.save(sec);
            return ResponseEntity.ok().body(sect);
        }
    }
@DeleteMapping("/section/delete/{id}")
    public ResponseEntity<Section> deleteSection(@PathVariable(value = "id") Long id){
        Optional<Section> temp=sections.findById(id);
        Section sec=temp.get();
        if(sec==null){
            return ResponseEntity.notFound().build();
        }else{
            sections.delete(sec);
            return ResponseEntity.ok().body(sec);
        }

}
}
