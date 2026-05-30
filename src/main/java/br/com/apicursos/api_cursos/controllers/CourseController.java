package br.com.apicursos.api_cursos.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.apicursos.api_cursos.dto.CreateCourseDTO;
import br.com.apicursos.api_cursos.dto.UpdateCourseDTO;
import br.com.apicursos.api_cursos.useCases.CreateCourseUseCase;
import br.com.apicursos.api_cursos.useCases.DeleteCourseUseCase;
import br.com.apicursos.api_cursos.useCases.ListCourseUseCase;
import br.com.apicursos.api_cursos.useCases.ToggleCourseActiveUseCase;
import br.com.apicursos.api_cursos.useCases.UpdateCourseUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListCourseUseCase listCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private ToggleCourseActiveUseCase toggleCourseActiveUseCase;

    @PostMapping
    public ResponseEntity<Object> create(
            @Valid @RequestBody CreateCourseDTO dto){

        return ResponseEntity.ok(
            createCourseUseCase.execute(dto));
    }

    @GetMapping
    public ResponseEntity<Object> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category){

        return ResponseEntity.ok(
            listCourseUseCase.execute(name, category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable UUID id,
            @RequestBody UpdateCourseDTO dto){

        return ResponseEntity.ok(
            updateCourseUseCase.execute(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable UUID id){

        deleteCourseUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> toggleActive(
            @PathVariable UUID id){

        return ResponseEntity.ok(
            toggleCourseActiveUseCase.execute(id));
    }
}
