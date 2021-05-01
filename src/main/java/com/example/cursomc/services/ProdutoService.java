package com.example.cursomc.services;

import com.example.cursomc.domain.Produto;
import com.example.cursomc.repositories.ProdutoRepository;
import com.example.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    public Produto buscar( Integer id){
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado, Id: "
                + id + ", Tipo:" + Produto.class.getName()));
    }
}
