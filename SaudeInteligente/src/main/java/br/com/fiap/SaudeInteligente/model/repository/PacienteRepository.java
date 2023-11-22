package br.com.fiap.SaudeInteligente.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.SaudeInteligente.model.entity.Paciente;


public class PacienteRepository extends Repository {

	public static ArrayList<Paciente> findAll() {
	    ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

	    String sql = "select * from tb_paciente";
	    try (PreparedStatement ps = getConnection().prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Paciente paciente = new Paciente();
	            paciente.setId(rs.getLong("id"));
	            paciente.setNome(rs.getString("nome"));
	            paciente.setCpf(rs.getString("cpf"));
	            paciente.setDataNascimento(rs.getString("dataNascimento"));
	            paciente.setSexo(rs.getString("sexo"));
	            paciente.setEndereco(rs.getString("endereco"));
	            paciente.setTelefone(rs.getString("telefone"));
	            paciente.setEmail(rs.getString("email"));
	            paciente.setDoencas(rs.getString("doencas"));
	            pacientes.add(paciente);
	        }

	    } catch (SQLException e) {
	        System.out.println("Erro ao listar: " + e.getMessage());
	    } finally {
	        closeConnection();
	    }
	    return pacientes;
	}


    
	
	public static Paciente save(Paciente Paciente) {
		String sql = "insert into tb_paciente"
				+ "(id, nome, cpf, dataNascimento, sexo, endereco, telefone, email, doencas)"
				+ " values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, Paciente.getNome());
			ps.setString(2, Paciente.getCpf());
			ps.setString(3, Paciente.getDataNascimento());
			ps.setString(4, Paciente.getSexo());
			ps.setString(5, Paciente.getEndereco());
			ps.setString(6, Paciente.getTelefone());
			ps.setString(7, Paciente.getEmail());
			ps.setString(8, Paciente.getDoencas());
			
			if (ps.executeUpdate() > 0) {
				return Paciente;
			} else {				
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static boolean delete(Long id) {
		String sql = "delete from tb_paciente where id = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao excluir: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
	
	public static Paciente update(Paciente paciente) {
	    String sql = "update tb_paciente "
	            + "set nome=?, cpf=?, dataNascimento=?, sexo=?, endereco=?, telefone=?, email=?, doencas=? "
	            + "where id=?";

	    try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
	        ps.setString(1, paciente.getNome());
	        ps.setString(2, paciente.getCpf());
	        ps.setString(3, paciente.getDataNascimento());
	        ps.setString(4, paciente.getSexo());
	        ps.setString(5, paciente.getEndereco());
	        ps.setString(6, paciente.getTelefone());
	        ps.setString(7, paciente.getEmail());
	        ps.setString(8, paciente.getDoencas());
	        ps.setLong(9, paciente.getId()); 

	        if (ps.executeUpdate() > 0) {
	            return paciente;
	        } else {
	            return null;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao atualizar: " + e.getMessage());
	    } finally {
	        closeConnection();
	    }

	    return null;
	}

	
	public static Paciente findById(Long id) {
		String sql = "select * from tb_paciente where id=?";
		Paciente paciente = new Paciente();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
                paciente.setId(rs.getLong("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setDataNascimento(rs.getString("dataNascimento"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setEmail(rs.getString("email"));
                paciente.setDoencas(rs.getString("doencas"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return paciente;
	}
	

	public static List<Paciente> findByNome(String nome) {
        List<Paciente> pacientesEncontrados = new ArrayList<>();
        String sql = "SELECT * FROM tb_paciente WHERE nome LIKE ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Paciente paciente = new Paciente();
                    paciente.setId(rs.getLong("id"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setDataNascimento(rs.getString("dataNascimento"));
                    paciente.setSexo(rs.getString("sexo"));
                    paciente.setEndereco(rs.getString("endereco"));
                    paciente.setTelefone(rs.getString("telefone"));
                    paciente.setEmail(rs.getString("email"));
                    paciente.setDoencas(rs.getString("doencas"));
                    pacientesEncontrados.add(paciente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar por nome: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pacientesEncontrados;
    }
	
	public static List<Paciente> findBySexo(String sexo) {
	    List<Paciente> pacientesEncontrados = new ArrayList<>();
	    String sql = "SELECT * FROM tb_paciente WHERE sexo = ?";
	    try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
	        ps.setString(1, sexo);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Paciente paciente = new Paciente();
	                paciente.setId(rs.getLong("id"));
	                paciente.setNome(rs.getString("nome"));
	                paciente.setCpf(rs.getString("cpf"));
	                paciente.setDataNascimento(rs.getString("dataNascimento"));
	                paciente.setSexo(rs.getString("sexo"));
	                paciente.setEndereco(rs.getString("endereco"));
	                paciente.setTelefone(rs.getString("telefone"));
	                paciente.setEmail(rs.getString("email"));
	                paciente.setDoencas(rs.getString("doencas"));
	                pacientesEncontrados.add(paciente);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao buscar por sexo: " + e.getMessage());
	    } finally {
	        closeConnection();
	    }
	    return pacientesEncontrados;
	}

}
