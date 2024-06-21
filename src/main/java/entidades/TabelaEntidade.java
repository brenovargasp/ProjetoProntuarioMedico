package entidades;

public class TabelaEntidade {

    String id, nomeMedico, data;

    public TabelaEntidade(String id, String nomeMedico, String data) {
        this.id = id;
        this.nomeMedico = nomeMedico;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
