package br.com.academia.aplication.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.academia.aplication.util.StringUtils;
import br.com.academia.aplication.util.Validation;
import br.com.academia.aplication.util.ValidationException;
import br.com.academia.domain.aluno.Aluno;
import br.com.academia.domain.aluno.AlunoRepository;

@Stateless
public class AlunoService {
	
	@EJB
	private AlunoRepository alunoRepository;
	
	public void createOrUpdate(Aluno aluno) {
		if(StringUtils.isEmpty(aluno.getMatricula())) {
			create(aluno);
		}else {
			update(aluno);
		}
	}

	private void update(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		Validation.assertNotEmpty(aluno.getMatricula());
		alunoRepository.update(aluno);
	}

	private void create(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		aluno.gerarMatricula(alunoRepository.getMaxMatriculaAno());
		alunoRepository.store(aluno);
	}
	
	public Aluno findByMatricula(String matricula) {
		return alunoRepository.findByMatricula(matricula);
	}
	
	public List<Aluno> pesquisar(String matricula, String nome, Integer rg,Integer telefone){
		if(StringUtils.isEmpty(matricula)&&StringUtils.isEmpty(nome)&& rg==null&&telefone==null ) {
			throw new ValidationException("Erro ao buscar alunos, informe algum parametro?");
		}
		return alunoRepository.listAlunos(matricula, nome, rg, telefone);
	}


}
