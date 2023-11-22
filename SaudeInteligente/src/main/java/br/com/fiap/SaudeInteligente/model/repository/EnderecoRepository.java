package br.com.fiap.SaudeInteligente.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.SaudeInteligente.model.entity.Endereco;



public class EnderecoRepository extends Repository {
	public static ArrayList<Endereco> findAll() {
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

        String sql = "select * from tb_endereco";
        try (PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	Endereco endereco = new Endereco();
            	endereco.setIdendereco(rs.getLong("id"));
            	endereco.setPaciente(rs.getString("paciente"));
            	endereco.setLogradouro(rs.getString("logradouro"));
            	endereco.setNumero(rs.getString("numero"));
            	endereco.setComplemento(rs.getString("complemento"));
            	endereco.setCep(rs.getString("cep"));
            	enderecos.add(endereco);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return enderecos;
    }



    
	
	public static Endereco save(Endereco Endereco) {
		String sql = "insert into tb_endereco"
				+ "(idendereco, paciente, logradouro, numero, complemento, cep)"
				+ " values(null, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, Endereco.getPaciente());
			ps.setString(2, Endereco.getLogradouro());
			ps.setString(3, Endereco.getNumero());
			ps.setString(4, Endereco.getComplemento());
			ps.setString(5, Endereco.getCep());						
			if (ps.executeUpdate() > 0) {
				return Endereco;
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
	
		public static boolean delete(Long idendereco) {
			String sql = "delete from tb_endereco where idendereco = ?";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setLong(1, idendereco);
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
		
		public static Endereco update(Endereco endereco) {
		    String sql = "update tb_endereco "
		            + "set idendereco=?, paciente=?, logradouro=?, numero=?, complemento=?, cep=? "
		            + "where id=?";

		    try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
		    	ps.setString(1, endereco.getPaciente());
				ps.setString(2, endereco.getLogradouro());
				ps.setString(3, endereco.getNumero());
				ps.setString(4, endereco.getComplemento());
				ps.setString(5, endereco.getCep());		
		        ps.setLong(6, endereco.getIdendereco());

		        if (ps.executeUpdate() > 0) {
		            return endereco;
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


		
		public static Endereco findByIdendereco(Long idendereco) {
			String sql = "select * from tb_endereco where idendereco=?";
			Endereco  endereco = new Endereco();
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setLong(1, idendereco);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {					               
					endereco.setIdendereco(rs.getLong("id"));
	            	endereco.setPaciente(rs.getString("paciente"));
	            	endereco.setLogradouro(rs.getString("logradouro"));
	            	endereco.setNumero(rs.getString("numero"));
	            	endereco.setComplemento(rs.getString("complemento"));
	            	endereco.setCep(rs.getString("cep"));
				} else {
					return null;
				}
			} catch (SQLException e) {
				System.out.println("Erro ao listar: " + e.getMessage());
			} finally {
				closeConnection();
			}
			return endereco;
		}
		

		

}
