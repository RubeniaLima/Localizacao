package localizacao;

import localizacao.entity.Cidade;
import localizacao.repository.CidadeRepository;
import localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApolication implements CommandLineRunner {

  @Autowired
  private CidadeService cidadeService;

    @Override
    public void run(String... args) throws Exception {
      cidadeService.listarCidadesByNomeSpec();

    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApolication.class,args);
    }


}
