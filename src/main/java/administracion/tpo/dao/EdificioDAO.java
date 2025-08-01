package administracion.tpo.dao;

import administracion.tpo.modelo.Edificio;
import administracion.tpo.modelo.Persona;
import administracion.tpo.repository.IRepositoryEdificio;
import administracion.tpo.repository.IRepositoryPersona;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/edificios")
public class EdificioDAO {
    private static EdificioDAO instance;

    private EdificioDAO(){

    }

    public static EdificioDAO getInstance() {
        if(instance==null){
            instance = new EdificioDAO();
        }
        return instance;
    }
    
    @GetMapping
    public List<Edificio> getAll(IRepositoryEdificio iRepositoryEdificio){
        return iRepositoryEdificio.findAll();
    }
    public Optional<Edificio> getById(int codigo, IRepositoryEdificio iRepositoryEdificio){
        return iRepositoryEdificio.findById(codigo);
    }

    public void save(Edificio edificio, IRepositoryEdificio iRepositoryEdificio){
        iRepositoryEdificio.save(edificio);
    }

    public void delete(int codigo, IRepositoryEdificio iRepositoryEdificio){
        iRepositoryEdificio.deleteById(codigo);
    }
    
    public void update(Edificio ed,IRepositoryEdificio iRepositoryEdificio){
        if (iRepositoryEdificio.existsById(ed.getCodigo())) {
        	iRepositoryEdificio.save(ed);
        }
    }

}
