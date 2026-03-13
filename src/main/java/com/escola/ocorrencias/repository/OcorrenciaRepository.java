
package com.escola.ocorrencias.repository;
import com.escola.ocorrencias.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia,Long>{
    List<Ocorrencia> findByProfessorCodigo(String codigo);
    List<Ocorrencia> findByEstudanteMatricula(String matricula);
}
