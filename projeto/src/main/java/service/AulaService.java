package service;

import com.sistema_aulas.projeto.Aula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AulaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;

    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public Aula criarAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    public List<Aula> listarAulas() {
        return aulaRepository.findAll();
    }

    public Optional<Aula> buscarAulaPorId(Long id) {
        return aulaRepository.findById(id);
    }

    public void deletarAula(Long id) {
        aulaRepository.deleteById(id);
    }
}

