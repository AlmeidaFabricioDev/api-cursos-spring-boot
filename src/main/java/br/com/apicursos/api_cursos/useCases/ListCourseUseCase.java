package br.com.apicursos.api_cursos.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apicursos.api_cursos.entities.CourseEntity;
import br.com.apicursos.api_cursos.repositories.CourseRepository;

@Service
public class ListCourseUseCase {

    @Autowired
    private CourseRepository repository;

    public List<CourseEntity> execute(String name, String category){

        List<CourseEntity> courses = repository.findAll();

        if(name != null && !name.isBlank()){
            courses = courses.stream()
                .filter(c -> c.getName().toLowerCase()
                .contains(name.toLowerCase()))
                .toList();
        }

        if(category != null && !category.isBlank()){
            courses = courses.stream()
                .filter(c -> c.getCategory().toLowerCase()
                .contains(category.toLowerCase()))
                .toList();
        }

        return courses;
    }
}