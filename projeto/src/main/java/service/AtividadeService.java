package service;

import com.sistema_aulas.projeto.Atividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AtividadeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Atividade criarAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public List<Atividade> listarAtividades() {
        return atividadeRepository.findAll();
    }

    public Optional<Atividade> buscarAtividadePorId(Long id) {
        return atividadeRepository.findById(id);
    }

    public void deletarAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }

    public AtividadeRepository getAtividadeRepository() {
        return atividadeRepository;
    }

    public void setAtividadeRepository(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }
}

