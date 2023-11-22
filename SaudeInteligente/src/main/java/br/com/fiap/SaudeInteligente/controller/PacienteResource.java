package br.com.fiap.SaudeInteligente.controller;



import br.com.fiap.SaudeInteligente.model.entity.Paciente;
import br.com.fiap.SaudeInteligente.model.services.PacienteServices;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/paciente")
public class PacienteResource {

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
	    return new PacienteServices().findById(id);
	}


	@GET
	@Path("/nome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByNome(@PathParam("nome") String nome) {
	    return new PacienteServices().findByNome(nome);
	}

	
	@GET
	@Path("/sexo/{sexo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBySexo(@PathParam("sexo") String sexo) {
	    return new PacienteServices().findBySexo(sexo);
	}

	
	@GET
	@Path("/findall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
	    return new PacienteServices().findAll();
	}
	
	@POST
	@Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid Paciente paciente) {
        return new PacienteServices().save(paciente);
    }

	
	 @DELETE
	 @Path("/delete/{id}")
	    public Response delete(@PathParam("id") Long id) {
	        return new PacienteServices().delete(id);
	    }
	
	 @PUT
	 @Path("/update")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response update(@Valid Paciente paciente) {
	        return new PacienteServices().update(paciente);
	    }
	}


