package br.com.academia.aplication.interfaces.aluno.web;

import java.io.Serializable;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.academia.aplication.service.AlunoService;
import br.com.academia.domain.aluno.Aluno;

@Named("alunoBean")
@RequestScoped
public class AlunoBean implements Serializable {
	
	@EJB
	private AlunoService alunoService;
	
	@Inject
	private FacesContext facesContext;

	private Aluno aluno =  new Aluno();
	
	private String matricula;
	
	private String titulo = "Novo Aluno";
	
	
	public String gravar() {
		alunoService.createOrUpdate(aluno);
		facesContext.addMessage(null, new FacesMessage("Salvo com sucesso."));
		return "";
	}
	
	public void carregar() {
		if(this.matricula != null) {
			aluno = alunoService.findByMatricula(this.matricula);
			titulo = "Alterar Aluno";
		}
		
	}


	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
