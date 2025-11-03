package application.controller;

import application.model.Afericao;
import application.repository.AfericaoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/afericoes")
public class AfericaoController {

    private final AfericaoRepository repository;

    public AfericaoController(AfericaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Afericao> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Afericao buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aferição não encontrada"));
    }

    @PostMapping
    public Afericao criar(@RequestBody Afericao afericao) {
        return repository.save(afericao);
    }

    @PutMapping("/{id}")
    public Afericao atualizar(@PathVariable Long id, @RequestBody Afericao dados) {
        Afericao afericao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrada"));
        afericao.setId_sensor(dados.getId_sensor());
        afericao.setUnidade(dados.getUnidade());
        afericao.setValor(dados.getValor());
        return repository.save(afericao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
