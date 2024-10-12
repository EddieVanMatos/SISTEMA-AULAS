package controller;

import com.sistema_aulas.projeto.Aula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AulaService;

import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping
    public ResponseEntity<Aula> criarAula(@RequestBody Aula aula) {
        return ResponseEntity.ok(aulaService.criarAula(aula));
    }

    @GetMapping
    public ResponseEntity<List<Aula>> listarAulas() {
        return ResponseEntity.ok(aulaService.listarAulas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> buscarAulaPorId(@PathVariable Long id) {
        return aulaService.buscarAulaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAula(@PathVariable Long id) {
        aulaService.deletarAula(id);
        return ResponseEntity.noContent().build();
    }
}

