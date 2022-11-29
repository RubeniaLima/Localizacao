package localizacao.service;

import localizacao.entity.Cidade;
import localizacao.repository.CidadeRepository;
import localizacao.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static localizacao.repository.specs.CidadeSpecs.habitantesGreaterThan;
import static localizacao.repository.specs.CidadeSpecs.nomeEqual;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional
    void salvarCidade(){
        var cidade = new Cidade(1L,"Recife", 105556L);
        cidadeRepository.save(cidade);
    }

    public void listarCidadesPorNome(){
        // cidadeRepository.findByNome("Recife").forEach(System.out::println);
        //cidadeRepository.findByNomeEndingWith("o").forEach(System.out::println);
        //cidadeRepository.findByNomeStartingWith("Porto").forEach(System.out::println);
        //cidadeRepository.findByNomeContaining("J").forEach(System.out::println);
        Pageable pageable = PageRequest.of(2,2);

        cidadeRepository.findByNomeLike("%%%%", pageable)
                .forEach(System.out::println);
    }
    public void listarCidadesPorQuantidadeDeHabitantes(){
        //cidadeRepository.findByHabitantesLessThanEqual(18000000L).forEach(System.out::println);
        cidadeRepository.
                findByHabitantesLessThanAndNomeLike(18000000L,"Br%")
                .forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes(){
        cidadeRepository.findByHabitantes(25325674L).forEach(System.out::println);
    }

    public void listarCidades(){
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher =  ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade,matcher);
        return cidadeRepository.findAll(example);

    }
    public void listarCidadesByNomeSpec(){
        //Specification<Cidade> nomeEqRecife = CidadeSpecs.nomeEqual("Recife");
        cidadeRepository.findAll(nomeEqual("Teresina")
                .and(habitantesGreaterThan(1000L)))
                .forEach(System.out::println);
    }

}
