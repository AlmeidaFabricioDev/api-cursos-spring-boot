package br.com.apicursos.api_cursos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apicursos.api_cursos.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
}