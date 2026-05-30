package br.com.apicursos.api_cursos.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apicursos.api_cursos.dto.CreateCourseDTO;
import br.com.apicursos.api_cursos.entities.CourseEntity;
import br.com.apicursos.api_cursos.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository repository;

    public CourseEntity execute(CreateCourseDTO dto){

        CourseEntity course = new CourseEntity();

        course.setName(dto.name());
        course.setCategory(dto.category());
        course.setProfessor(dto.professor());
        course.setActive(true);

        return repository.save(course);
    }
}
