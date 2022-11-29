package localizacao.repository;

import localizacao.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    //Busca Ordenada
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    //Busca paginada
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);

    List<Cidade> findByNomeStartingWith(String nome);

    List<Cidade> findByNomeEndingWith(String nome);

    List<Cidade> findByNomeContaining(String nome);
    List<Cidade> findByHabitantes(Long nome);

    List<Cidade> findByHabitantesLessThan(Long Habitantes);

    List<Cidade> findByHabitantesGreaterThan(Long Habitantes);

    List<Cidade> findByHabitantesLessThanEqual(Long Habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long Habitantes, String nome);


}
