package jmock.jmock;

import java.time.LocalDate;

public class CadastrarPessoa {
	
	private ApiDosCorreios apiDosCorreios;
	
	public CadastrarPessoa(final ApiDosCorreios apiDOsCorreios) {
		this.apiDosCorreios = apiDOsCorreios;
	}
	
	public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, String cep) {
		Pessoa pessoa = new Pessoa(nome, documento, nascimento);
		DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaNaBaseDosCorreios(cep);
		pessoa.adicionaDadosEndereco(dadosLocalizacao);
		return pessoa;
	}
}
