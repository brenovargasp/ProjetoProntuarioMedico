package entidades;

public class ProntuarioMedico {
    String anamnese;
    String plano_terapeutico;
    String encaminhamento;
    String id_Funcionario;
    String id_Atendimento;

    public ProntuarioMedico(String anamnese, String plano_terapeutico, String encaminhamento, String id_Funcionario, String id_Atendimento) {
        this.anamnese = anamnese;
        this.plano_terapeutico = plano_terapeutico;
        this.encaminhamento = encaminhamento;
        this.id_Funcionario = id_Funcionario;
        this.id_Atendimento = id_Atendimento;
    }

    public String getId_Funcionario() {
        return id_Funcionario;
    }

    public void setId_Funcionario(String id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }

    public String getId_Atendimento() {
        return id_Atendimento;
    }

    public void setId_Atendimento(String id_Atendimento) {
        this.id_Atendimento = id_Atendimento;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getPlano_terapeutico() {
        return plano_terapeutico;
    }

    public void setPlano_terapeutico(String plano_terapeutico) {
        this.plano_terapeutico = plano_terapeutico;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }
}
