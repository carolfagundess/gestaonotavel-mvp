
package br.com.gestaonotavel.gestaonotavel.mvp.dao.impl;

import br.com.gestao.notavel.mvp.dao.GenericDAOImpl;
import br.com.gestaonotavel.gestaonotavel.mvp.model.Responsavel;

/**
 *
 * @author carol
 */
public class ResponsavelDAO extends GenericDAOImpl<Responsavel, String>{

    public ResponsavelDAO() {
        super(Responsavel.class);
    }
}
