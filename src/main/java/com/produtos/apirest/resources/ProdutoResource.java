package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.produtos.apirest.models.Produto;


@RestController
@RequestMapping(value="/api")
@Api(value="/api")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos.")
	public List<Produto> getListProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retornar os detalhes de um produto.")
	public Produto getProduto (@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="Grava um novo produto.")
	public Produto postProduto (@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produtos/{id}")
	@ApiOperation(value="Deleta um produto existente.")
	public void deleteProduto (@PathVariable(value="id") long id) {
		produtoRepository.deleteById(id);
	}

	@PutMapping("/produtos")
	@ApiOperation(value="Altera um produto existente.")
	public Produto putProduto (@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
