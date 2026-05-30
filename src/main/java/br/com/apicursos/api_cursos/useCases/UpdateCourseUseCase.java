package br.com.apicursos.api_cursos.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apicursos.api_cursos.dto.UpdateCourseDTO;
import br.com.apicursos.api_cursos.entities.CourseEntity;
import br.com.apicursos.api_cursos.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository repository;

    public CourseEntity execute(UUID id, UpdateCourseDTO dto){

        CourseEntity course = repository.findById(id)
            .orElseThrow(() ->
                new RuntimeException("Curso não encontrado"));

        if(dto.name() != null){
            course.setName(dto.name());
        }

        if(dto.category() != null){
            course.setCategory(dto.category());
        }

        if(dto.professor() != null){
            course.setProfessor(dto.professor());
        }

        return repository.save(course);
    }
}