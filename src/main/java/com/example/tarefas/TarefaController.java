package com.example.tarefas;

import com.exemplo.tarefas.model.Tarefa;
import com.exemplo.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    // Criar uma nova tarefa
    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    // Listar todas as tarefas
    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    // Buscar tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa novaTarefa) {
        return repository.findById(id).map(tarefa -> {
            tarefa.setNome(novaTarefa.getNome());
            tarefa.setDataEntrega(novaTarefa.getDataEntrega());
            tarefa.setResponsavel(novaTarefa.getResponsavel());
            return ResponseEntity.ok(repository.save(tarefa));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Remover tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return repository.findById(id).map(tarefa -> {
            repository.delete(tarefa);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}