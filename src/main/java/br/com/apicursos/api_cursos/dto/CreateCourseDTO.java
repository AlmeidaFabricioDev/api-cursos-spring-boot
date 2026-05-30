package br.com.apicursos.api_cursos.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCourseDTO(

    @NotBlank(message = "Nome é obrigatório")
    String name,

    @NotBlank(message = "Categoria é obrigatória")
    String category,

    @NotBlank(message = "Professor é obrigatório")
    String professor

) {}