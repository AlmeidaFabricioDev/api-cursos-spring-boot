package br.com.apicursos.api_cursos.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apicursos.api_cursos.entities.CourseEntity;
import br.com.apicursos.api_cursos.exceptions.CourseNotFoundException;
import br.com.apicursos.api_cursos.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository repository;

    public void execute(UUID id){

        CourseEntity course = repository.findById(id)
            .orElseThrow(CourseNotFoundException::new);

        repository.delete(course);
    }
}