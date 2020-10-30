package com.anderson.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //transforma a classe em uma entidade do JPA, banco de dados
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	//1º Atributos básicos, por padrão todas classes são private (não acessíveis por outras):
	
	//definindo id como chave primária
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String nome;
	
	//2º Criando construtores:
	public Categoria() {
		//criado construtor "vazio", para podermos instanciar o objeto sem "jogar nada para os atributos"

	}
	/*Utilizando gerador de códigos automático para criar outro construtor, agora com os atributos "id e nome", 
	para povoá-los
	RIGHT CLICK > SOURCE > GENERATE CONSTRUCTOR USING FIELDS > FORAM MANTIDOS OS 2 ITENS (ID e NOME) > OK*/

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	/*3º Getters e setters para acessar os atributos id e nome que estão como private
	 RIGHT CLICK > SOURCE > GENERATE Getters e setters > FORAM MANTIDOS OS 2 ITENS (ID e NOME) > OK 
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*4º Criados hashCode e equals, que são utilizados para comparar 2 objetos por seus conteúdos (valor) e não por
	 * ponteiros de memória
	 * RIGHT CLICK > SOURCE > GENERATE hashCode e equals > somente o ID foi MANTIDO > OK
	 * */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	/*5º Implementado a interface Serializable em >> "public class Categoria implements Serializable" (ver 1º). 
	 * Isto converte os objetos da classe para uma sequência de bytes e assim poderem ser gravados em arquivos, 
	 * trafegar em redes etc. É uma exigência do JAVA */	
	
}
