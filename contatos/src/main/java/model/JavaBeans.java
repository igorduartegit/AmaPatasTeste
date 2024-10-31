package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The idcon. */
	private String idcon;
	
	/** The nome. */
	private String nome;
	
	/** The fone. */
	private String fone;
	
	/** The email. */
	private String email;
	
	/** The apoiador. */
	private String apoiador;
	
	/** The idpet. */
	private String idpet;
	
	/** The nomepet. */
	private String nomepet;
	
	/** The especie. */
	private String especie;
	
	/** The idade. */
	private String idade;
	
	/** The sexo. */
	private String sexo;
	
	/** The situacao. */
	private String situacao;
	
	/**
	 * Gets the idpet.
	 *
	 * @return the idpet
	 */
	public String getIdpet() {
		return idpet;
	}

	/**
	 * Sets the idpet.
	 *
	 * @param idpet the new idpet
	 */
	public void setIdpet(String idpet) {
		this.idpet = idpet;
	}
	
	/**
	 * Gets the nomepet.
	 *
	 * @return the nomepet
	 */
	public String getNomepet() {
		return nomepet;
	}

	/**
	 * Sets the nomepet.
	 *
	 * @param nomepet the new nomepet
	 */
	public void setNomepet(String nomepet) {
		this.nomepet = nomepet;
	}

	/**
	 * Gets the especie.
	 *
	 * @return the especie
	 */
	public String getEspecie() {
		return especie;
	}

	/**
	 * Sets the especie.
	 *
	 * @param especie the new especie
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	/**
	 * Gets the idade.
	 *
	 * @return the idade
	 */
	public String getIdade() {
		return idade;
	}

	/**
	 * Sets the idade.
	 *
	 * @param idade the new idade
	 */
	public void setIdade(String idade) {
		this.idade = idade;
	}

	/**
	 * Gets the sexo.
	 *
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Sets the sexo.
	 *
	 * @param sexo the new sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Gets the situacao.
	 *
	 * @return the situacao
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * Sets the situacao.
	 *
	 * @param situacao the new situacao
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();	
	}
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param idcon the idcon
	 * @param nome the nome
	 * @param fone the fone
	 * @param email the email
	 * @param apoiador the apoiador
	 */
	
	public JavaBeans(String idcon, String nome, String fone, String email, String apoiador) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.apoiador = apoiador;
	}
		
	/**
	 * Instantiates a new java beans.
	 *
	 * @param idpet the idpet
	 * @param nomepet the nomepet
	 * @param especie the especie
	 * @param idade the idade
	 * @param sexo the sexo
	 * @param situacao the situacao
	 */
	public JavaBeans (String idpet, String nomepet, String especie, String idade, String sexo, String situacao) {
		
		this.idpet = idpet;
		this.nomepet = nomepet;
		this.especie = especie;
		this.idade = idade;
		this.sexo = sexo;
		this.situacao = situacao;
	}
	
	/* ALTERADO DE: 
	 * public JavaBeans(String idcon, String nome, String fone, String email, String apoiador, 
	 
			String idpet, String nomepet, String especie, String idade, String sexo, String situacao) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.apoiador = apoiador;
		this.idpet = idpet;
		this.nomepet = nomepet;
		this.especie = especie;
		this.idade = idade;
		this.sexo = sexo;
		this.situacao = situacao;
	}
*/
	
	
	/**
	 * Gets the idcon.
	 *
	 * @return the idcon
	 */
	public String getIdcon() {
		return idcon;
	}
	
	/**
	 * Sets the idcon.
	 *
	 * @param idcon the new idcon
	 */
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the fone.
	 *
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}
	
	/**
	 * Sets the fone.
	 *
	 * @param fone the new fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the apoiador.
	 *
	 * @return the apoiador
	 */
	public String getApoiador() {
		return apoiador;
	}
	
	/**
	 * Sets the apoiador.
	 *
	 * @param apoiador the new apoiador
	 */
	public void setApoiador(String apoiador) {
		this.apoiador = apoiador;
	}

}
