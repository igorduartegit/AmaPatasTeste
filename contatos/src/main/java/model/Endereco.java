package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Endereco.
 */
public class Endereco {

    /** The cep. */
    private String cep;
    
    /** The logradouro. */
    private String logradouro;
    
    /** The bairro. */
    private String bairro;
	
	/** The localidade. */
	private String localidade;
    
    /** The uf. */
    private String uf;

    /**
     * Gets the cep.
     *
     * @return the cep
     */
    // Getters e Setters
    public String getCep() {
        return cep;
    }

    /**
     * Sets the cep.
     *
     * @param cep the new cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Gets the logradouro.
     *
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Sets the logradouro.
     *
     * @param logradouro the new logradouro
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * Gets the bairro.
     *
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Sets the bairro.
     *
     * @param bairro the new bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Gets the localidade.
     *
     * @return the localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * Sets the localidade.
     *
     * @param localidade the new localidade
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Gets the uf.
     *
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * Sets the uf.
     *
     * @param uf the new uf
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
}
