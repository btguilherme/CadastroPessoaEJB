/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.ejb;

import cadastro.dao.PessoaDAO;
import cadastro.modelo.Pessoa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gcamargo
 */
@Stateless
public class PessoaBean implements PessoaRemote{

    @PersistenceContext(unitName = "CadastroPessoaEJBPU")
    private EntityManager em;
    
    @Override
    public Pessoa inserir(Pessoa p) throws Exception {
        PessoaDAO dao = new PessoaDAO(em);
        return dao.inserir(p);
    }

    @Override
    public Pessoa consultarPorId(Long id) {
        PessoaDAO dao = new PessoaDAO(em);
        return dao.consultaPorId(id);
    }

    @Override
    public void remover(Long id) {
        PessoaDAO dao = new PessoaDAO(em);
        dao.remover(id);
    }
    
}
