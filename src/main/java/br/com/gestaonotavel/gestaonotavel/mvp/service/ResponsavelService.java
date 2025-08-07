package br.com.gestaonotavel.gestaonotavel.mvp.service;

import br.com.gestaonotavel.gestaonotavel.mvp.dao.impl.ResponsavelDAO;
import br.com.gestaonotavel.gestaonotavel.mvp.model.Responsavel;
import java.util.List;

/**
 *
 * @author carol
 */
public class ResponsavelService {
    
    private ResponsavelDAO responsavelDAO;

    public ResponsavelService() {
        //criando um objeto para uso do service durante os metodos
        this.responsavelDAO = new ResponsavelDAO();
    }

    public void cadastrarResponsavel(Responsavel responsavel) throws Exception {
        if (responsavel == null) {
            throw new Exception("O objeto responsável não pode ser nulo");
        }

        if (responsavel.getNome() == null || responsavel.getNome().trim().isEmpty()) {
            throw new Exception("O nome do responsável é obrigatório.");
        }
        
        if (responsavel.getNome() == null || responsavel.getNome().trim().isEmpty()) {
            throw new Exception("O nome não pode ser nulo");
        }
        
        responsavelDAO.salvar(responsavel);
    }
    
    public List<Responsavel> buscarTodos(){
        List<Responsavel> lista = responsavelDAO.buscarTodos();
        return lista;
    }

}
