package fj21.tarefas.struts2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarefa {
	private Long id;
	private String descricao;
	private boolean finalizado;
	private Date dataFinalizado;
	
	public Long getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Long.parseLong(id);
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Date getDataFinalizado() {
		return this.dataFinalizado;
	}
	public void setDataFinalizado(String dataFinalizado){
		try {
			Date data =new SimpleDateFormat("yyyy-MM-dd").parse(dataFinalizado);
			this.dataFinalizado=(Date) data;
		} catch (java.text.ParseException e) {
			System.out.println("problema na data da tarefa");
			
			return;// para execu��o do metodo
		}
	}
	public String toString(){
		return this.id+" "+this.finalizado+" "+this.dataFinalizado+" "+this.descricao;
	}
}
