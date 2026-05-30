package br.com.apicursos.api_cursos.dto;

public record UpdateCourseDTO(
    String name,
    String category,
    String professor
) {}