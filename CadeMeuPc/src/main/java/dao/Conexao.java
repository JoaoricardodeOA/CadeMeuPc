package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;

import model.Equipamento;
import model.Ocorrencia;

public class Conexao {
	public Conexao() {

	}

	public Equipamento lerEnviarEquipamento(Equipamento e) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		Equipamento e1;
		List<Equipamento> list = em
				.createQuery("SELECT a FROM Equipamento a where a.serialNumber ='" + e.getSerialNumber() + "'",
						Equipamento.class)
				.getResultList();
		if (list.size() == 0) {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} else if (list.get(0).isManutencao()) {
			return null;
		} else {
			System.out.println(list);
			e1 = em.find(Equipamento.class, list.get(0).getId());
			em.getTransaction().begin();
			e1.setVezesQuebrado(e1.getVezesQuebrado() + 1);
			e1.setEmpresa(e.getEmpresa());
			e1.setReponsavel(e.getReponsavel());
			e1.setManutencao(true);
			em.getTransaction().commit();
			e = e1;
		}
		em.close();
		emf.close();
		return e;
	}

	public void lerEnviarOcorrencia(Ocorrencia o) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public void lerAtualizar(Ocorrencia o) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		Ocorrencia o2;
		o2 = em.find(Ocorrencia.class, o.getId());
		if (o2 != null) {
			em.getTransaction().begin();
			o2.setnF(o.getnF());
			o2.setoS(o.getoS());
			o2.setValor(o.getValor());
			em.getTransaction().commit();
			em.close();
			emf.close();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "ID incorreto");
		}

	}

	public void lerReceber(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		Ocorrencia o = em.find(Ocorrencia.class, id);
		if (o != null) {
			Equipamento e = o.getEquipamento();
			em.getTransaction().begin();
			o.setSituacao(false);
			e.setManutencao(false);
			em.getTransaction().commit();
			em.close();
			emf.close();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "ID incorreto");
		}
	}
	public List<Equipamento> queryEnviado() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		List<Equipamento> list = em
				.createQuery("SELECT a FROM Equipamento a where a.manutencao=TRUE",
						Equipamento.class)
				.getResultList();
		em.close();
		emf.close();
		Collections.sort(list);
		return list;
		
		
	}
	public List<Equipamento> queryTodos(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		List<Equipamento> list = em
				.createQuery("SELECT a FROM Equipamento a",
						Equipamento.class)
				.getResultList();
		em.close();
		emf.close();
		Collections.sort(list);
		return list;
	}
	public List<Ocorrencia> queryData(Date data, Date data1){
		List<Ocorrencia> todas= queryTodasO();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String inicio = formatter.format(data);
		String fim = formatter.format(data1);
 		String formatado;
 		List<Ocorrencia> query= new ArrayList<Ocorrencia>();
		for (Ocorrencia ocorrencia : todas) {
			formatado = formatter.format(ocorrencia.getMes());
			if(formatado.compareTo(inicio)>=0&&formatado.compareTo(fim)<=0) {
				query.add(ocorrencia);
			}
		}
		Collections.sort(query);
		return query;
	}
	public List<Ocorrencia> queryAtividade(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		List<Ocorrencia> list = em
				.createQuery("SELECT a FROM Ocorrencia a where a.situacao = TRUE",
						Ocorrencia.class)
				.getResultList();
		em.close();
		emf.close();
		Collections.sort(list);
		return list;
	}
	public List<Ocorrencia> queryTodasO(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		List<Ocorrencia> list = em
				.createQuery("SELECT a FROM Ocorrencia a",
						Ocorrencia.class)
				.getResultList();
		em.close();
		emf.close();
		return list;
	}
}
