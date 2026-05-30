package br.com.apicursos.api_cursos.exceptions;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException() {
        super("Curso não encontrado");
    }

}