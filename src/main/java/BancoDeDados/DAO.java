package BancoDeDados;

import entidades.Paciente;
import entidades.ProntuarioMedico;
import entidades.TabelaEntidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

    Paciente pacienteInfo;
    int id_Funcionario;


    public boolean verificaCpf(Paciente paciente) throws Exception {

        try(PreparedStatement ps = ConexaoDB.obtemConexao().prepareStatement("SELECT * FROM Paciente WHERE cpf = ?")) {

            ps.setString(1, paciente.getCpf());

            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    pacienteInfo = new Paciente(rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("data_nasc"),
                            rs.getString("celular"), rs.getString("endereco"), rs.getString("cidade"), rs.getString("cep"),
                            rs.getInt("nr_SUS"), rs.getString("genero"));
                    return true;
                } else {
                    return false;
                }
            }
        }
    }


    public boolean verificaFuncionario(String cpf) throws Exception {
        try(PreparedStatement ps = ConexaoDB.obtemConexao().prepareStatement("SELECT * FROM Funcionario WHERE cpf = ?")) {

            ps.setString(1, cpf);

            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    id_Funcionario = rs.getInt("idFuncionario");
                    return true;
                } else {
                    return false;
                }
            }
        }
    }


    public int pegaIdAtendimento(String cpf) throws Exception {
        try(PreparedStatement ps = ConexaoDB.obtemConexao().prepareStatement("SELECT * FROM Atendimento WHERE Paciente_cpf = ?")) {
            ps.setString(1, cpf);

            try(ResultSet rs = ps.executeQuery()) {
                int idAtendimento = 0;
                while(rs.next()) {
                    idAtendimento = rs.getInt("idAtendimento");
                }
                return idAtendimento;
            }
        }
    }


    public void adicionaProntuario(ProntuarioMedico prontuarioMedico) throws Exception {
        try(PreparedStatement ps = ConexaoDB.obtemConexao().prepareStatement("INSERT INTO Prontuario(Funcionario_idFuncionario, Atendimento_idAtendimento, anamnese, " +
                "plano_terapeutico, encaminhamento) VALUES (?, ?, ?, ?, ?)")) {

            ps.setString(1, prontuarioMedico.getId_Funcionario());
            ps.setString(2, prontuarioMedico.getId_Atendimento());
            ps.setString(3, prontuarioMedico.getAnamnese());
            ps.setString(4, prontuarioMedico.getPlano_terapeutico());
            ps.setString(5, prontuarioMedico.getEncaminhamento());

            ps.execute();
        }
    }

    public ArrayList<TabelaEntidade> pegaTabelaEntidade(String cpf) throws Exception {
        try(PreparedStatement ps = ConexaoDB.obtemConexao().prepareStatement("select Prontuario.idProntuario, Funcionario.nome, Atendimento.data_atendimento from Prontuario " +
                "join Funcionario on Prontuario.Funcionario_idFuncionario = Funcionario.idFuncionario " +
                "join Atendimento on Prontuario.Atendimento_idAtendimento = Atendimento.idAtendimento " +
                "where Atendimento.Paciente_cpf = ?")) {

            ps.setString(1, cpf);

            ArrayList<TabelaEntidade> valoresTabelaEntidades = new ArrayList<>();
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {

                    String dataFormatada = rs.getString("data_atendimento").replaceAll("[^0-9]", "");
                    String ano = dataFormatada.substring(0, 4);
                    String mes = dataFormatada.substring(4, 6);
                    String dia = dataFormatada.substring(6, 8);
                    String dataFinal = dia + "/" + mes + "/" + ano;

                    TabelaEntidade tabelaEntidade = new TabelaEntidade(rs.getString("idProntuario"),
                            rs.getString("nome"), dataFinal);
                    valoresTabelaEntidades.add(tabelaEntidade);
                }
                return valoresTabelaEntidades;
            }
        }
    }

    public ArrayList<String> preencheProntuario(String id) throws Exception {
        try(PreparedStatement ps = ConexaoDB.obtemConexao().prepareStatement("select Prontuario.anamnese, Prontuario.plano_terapeutico, Prontuario.encaminhamento, " +
                "Funcionario.cpf from Prontuario " +
                "join Funcionario on Prontuario.Funcionario_idFuncionario = Funcionario.idFuncionario " +
                "where Prontuario.idProntuario = ?")) {
            ps.setString(1, id);

            try(ResultSet rs = ps.executeQuery()) {
                rs.next();
                ArrayList<String> informacoes = new ArrayList<>();
                informacoes.add(rs.getString("anamnese"));
                informacoes.add(rs.getString("plano_terapeutico"));
                informacoes.add(rs.getString("encaminhamento"));
                informacoes.add(rs.getString("cpf"));
                return informacoes;
            } catch (Exception ex) {
                ex.getStackTrace();
                return null;
            }
        }
    }

    public Paciente getPaciente() {
        return pacienteInfo;
    }

    public int getId_Funcionario() {
        return id_Funcionario;
    }

}
