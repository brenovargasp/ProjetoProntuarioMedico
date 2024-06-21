package entidades;

public class Paciente {

    private String cpf;
    private String nome;
    private String email;
    private String data_nasc;
    private String celular;
    private String endereco;
    private String cidade;
    private String cep;
    private int nr_SUS;
    private String genero;

    public Paciente() {
    }

    public Paciente(String cpf) {
        this.cpf = cpf;
    }

    public Paciente(String cpf, String nome, String email, String data_nasc, String celular, String endereco,
                    String cidade, String cep, int nr_SUS, String genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.data_nasc = data_nasc;
        this.celular = celular;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.nr_SUS = nr_SUS;
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNr_SUS() {
        return nr_SUS;
    }

    public void setNr_SUS(int nr_SUS) {
        this.nr_SUS = nr_SUS;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
