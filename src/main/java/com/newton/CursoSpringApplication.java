package com.newton;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.newton.domain.Categoria;
import com.newton.domain.Cidade;
import com.newton.domain.Cliente;
import com.newton.domain.Endereco;
import com.newton.domain.Estado;
import com.newton.domain.Produto;
import com.newton.domain.enums.TipoCliente;
import com.newton.repositories.CategoriaRepository;
import com.newton.repositories.CidadeRepository;
import com.newton.repositories.ClienteRepository;
import com.newton.repositories.EnderecoRepository;
import com.newton.repositories.EstadoRepository;
import com.newton.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository category;
	@Autowired
	private ProdutoRepository product;
	@Autowired
	private EstadoRepository estado;
	@Autowired
	private CidadeRepository cidade;
	@Autowired
	private ClienteRepository cliente;
	@Autowired
	private EnderecoRepository endereco;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		category.saveAll(Arrays.asList(cat1, cat2));
		product.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estado.saveAll(Arrays.asList(est1, est2));
		cidade.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "11277371040", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("84911112222", "84922223333"));
		
		Endereco e1 = new Endereco(null, "Street Milk Shake", "123", "Apt 000", "Via Lactea", "59000000", cli1, c1);
		Endereco e2 = new Endereco(null, "Street Ovomaltino", "321", "Apt 999", "Andromeda", "59000001", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		cliente.saveAll(Arrays.asList(cli1));
		endereco.saveAll(Arrays.asList(e1, e2));
	}
}
