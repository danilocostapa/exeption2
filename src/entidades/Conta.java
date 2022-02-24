package entidades;

import exceptions.BusinessException;

public class Conta {
	/*Atributos*/
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	
	/*contrutores*/
	public Conta() {
	}

	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	/*gets e sets*/
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	/*métodos de negócio*/
	
	/*método para depositar*/
	public void deposito(double valor) {
		saldo += valor;
	}
	
	/*método para saque*/
	public void saque(double valor) {
		validarSaque(valor);
		saldo -= valor;
	}
	
	/*método para válidar saque*/
	private void validarSaque(double valor) {
		if(valor > getLimiteSaque()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque.");
		}
		if(valor > getSaldo()) {
			throw new BusinessException("Erro de saque: Saldo insuficiente");
		}
	}
}
