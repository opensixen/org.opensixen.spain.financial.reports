/**
 * 
 */
package org.opensixen.spain.financial.reports;

import java.math.BigDecimal;

/**
 * @author harlock
 *
 */
public class TestBean {

	private String value;
	
	private BigDecimal inicial;
	private BigDecimal debe;
	private BigDecimal haber;
	private BigDecimal saldo;
	
	
	
	public TestBean(String value, BigDecimal inicial, BigDecimal debe,
			BigDecimal haber, BigDecimal saldo) {
		super();
		this.value = value;
		this.inicial = inicial;
		this.debe = debe;
		this.haber = haber;
		this.saldo = saldo;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the inicial
	 */
	public BigDecimal getInicial() {
		return inicial;
	}
	/**
	 * @param inicial the inicial to set
	 */
	public void setInicial(BigDecimal inicial) {
		this.inicial = inicial;
	}
	/**
	 * @return the debe
	 */
	public BigDecimal getDebe() {
		return debe;
	}
	/**
	 * @param debe the debe to set
	 */
	public void setDebe(BigDecimal debe) {
		this.debe = debe;
	}
	/**
	 * @return the haber
	 */
	public BigDecimal getHaber() {
		return haber;
	}
	/**
	 * @param haber the haber to set
	 */
	public void setHaber(BigDecimal haber) {
		this.haber = haber;
	}
	/**
	 * @return the saldo
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
	
}
