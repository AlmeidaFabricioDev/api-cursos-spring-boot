package br.com.apicursos.api_cursos.exceptions;

public class CourseAlreadyExistsException extends RuntimeException {

    public CourseAlreadyExistsException() {
        super("Já existe um curso com esse nome");
    }

}