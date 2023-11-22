package br.com.fiap.SaudeInteligente.model.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.SaudeInteligente.model.entity.Paciente;
import br.com.fiap.SaudeInteligente.model.repository.PacienteRepository;
import jakarta.ws.rs.core.Response;

public class PacienteServices {

    private final ObjectMapper objectMapper;

    public PacienteServices() {
        this.objectMapper = new ObjectMapper();
    }

    public Response findAll() {
        List<Paciente> pacientes = PacienteRepository.findAll();
        return buildListResponse(pacientes, "Lista de pacientes obtida com sucesso", "Nenhum paciente encontrado");
    }

    private Response buildListResponse(List<?> data, String sucessoMsg, String nenhumEncontradoMsg) {
        Map<String, Object> responseMap = new HashMap<>();

        if (!data.isEmpty()) {
            responseMap.put("mensagem", sucessoMsg);
            responseMap.put("Pacientes", data);
        } else {
            responseMap.put("mensagem", nenhumEncontradoMsg);
        }

        return buildJsonResponse(responseMap);
    }

    private Response buildJsonResponse(Object entity) {
        return Response.ok(entity).build();
    }

    
    
    
    public Response findById(Long id) {
        Paciente pacienteEncontrado = PacienteRepository.findById(id);
        return buildResponse(pacienteEncontrado, "Paciente encontrado com sucesso", "Nenhum paciente encontrado para o ID: " + id);
    }

    private Response buildResponse(Object data, String sucessoMsg, String nenhumEncontradoMsg) {
        Map<String, Object> responseMap = new HashMap<>();

        if (data != null) {
            responseMap.put("mensagem", sucessoMsg);
            responseMap.put("paciente", data);
        } else {
            responseMap.put("mensagem", nenhumEncontradoMsg);
        }

        try {
            // Configuração para formatar o JSON
            String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseMap);
            return Response.ok(jsonResponse).build();
        } catch (JsonProcessingException e) {
            // Tratar exceção de formatação do JSON
            e.printStackTrace();
            return Response.status(500).entity("Erro ao formatar a resposta JSON").build();
        }
    }
        
        
    public Response findByNome(String nome) {
        List<Paciente> pacientesEncontrados = PacienteRepository.findByNome(nome);

        Map<String, Object> responseMap = new HashMap<>();

        if (!pacientesEncontrados.isEmpty()) {
            responseMap.put("mensagem", "Paciente encontrado com sucesso");
            responseMap.put("pacientes", pacientesEncontrados);
        } else {
            responseMap.put("mensagem", "Nenhum paciente encontrado para o nome: " + nome);
        }

        try {
            // Configuração para formatar o JSON
            String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseMap);
            return Response.ok(jsonResponse).build();
        } catch (JsonProcessingException e) {
            // Tratar exceção de formatação do JSON
            e.printStackTrace();
            return Response.status(500).entity("Erro ao formatar a resposta JSON").build();
        }
    }

 
    public Response save(Paciente paciente) {
        Paciente pacienteSalvo = PacienteRepository.save(paciente);

        Map<String, Object> responseMap = new HashMap<>();

        if (pacienteSalvo != null) {
            responseMap.put("mensagem", "Paciente salvo com sucesso");
            responseMap.put("paciente", pacienteSalvo);
            return Response.ok(responseMap).build();
        } else {
            responseMap.put("mensagem", "Erro ao salvar o paciente");
            
            try {
                // Configuração para formatar o JSON
                String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseMap);
                return Response.ok(jsonResponse).build();
            } catch (JsonProcessingException e) {
                // Tratar exceção de formatação do JSON
                e.printStackTrace();
                return Response.status(500).entity("Erro ao formatar a resposta JSON").build();
            }
        }
    }

    public Response delete(Long id) {
        if (PacienteRepository.delete(id)) {
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("mensagem", "Paciente excluído com sucesso");
            return Response.ok(responseMap).build();
        } else {
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("mensagem", "Erro ao excluir o paciente");

            try {
                // Configuração para formatar o JSON
                String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseMap);
                return Response.ok(jsonResponse).build();
            } catch (JsonProcessingException e) {
                // Tratar exceção de formatação do JSON
                e.printStackTrace();
                return Response.status(500).entity("Erro ao formatar a resposta JSON").build();
            }
        
        }
    }

    public Response update(Paciente paciente) {
        Paciente pacienteAtualizado = PacienteRepository.update(paciente);

        Map<String, Object> responseMap = new HashMap<>();

        if (pacienteAtualizado != null) {
            responseMap.put("mensagem", "Paciente atualizado com sucesso");
            responseMap.put("paciente", pacienteAtualizado);
            return Response.ok(responseMap).build();
        } else {
            responseMap.put("mensagem", "Erro ao atualizar o paciente");

            try {
                // Configuração para formatar o JSON
                String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseMap);
                return Response.ok(jsonResponse).build();
            } catch (JsonProcessingException e) {
                // Tratar exceção de formatação do JSON
                e.printStackTrace();
                return Response.status(500).entity("Erro ao formatar a resposta JSON").build();
            }
        }
    }

    
    public Response findBySexo(String sexo) {
        List<Paciente> pacientesEncontrados = PacienteRepository.findBySexo(sexo);

        Map<String, Object> responseMap = new HashMap<>();

        if (!pacientesEncontrados.isEmpty()) {
            responseMap.put("mensagem", "Pacientes encontrados com sucesso");
            responseMap.put("pacientes", pacientesEncontrados);
            return Response.ok(responseMap).build();
        } else {
            responseMap.put("mensagem", "Nenhum paciente encontrado para o sexo: " + sexo);
           
            try {
                // Configuração para formatar o JSON
                String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseMap);
                return Response.ok(jsonResponse).build();
            } catch (JsonProcessingException e) {
                // Tratar exceção de formatação do JSON
                e.printStackTrace();
                return Response.status(500).entity("Erro ao formatar a resposta JSON").build();
            }
        }
    }

}
