/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.dao;

import cadastro.modelo.Pessoa;
import javax.persistence.EntityManager;

/**
 *
 * @author gcamargo
 */
public class PessoaDAO {

    private EntityManager em;

    public PessoaDAO(EntityManager em) {
        this.em = em;
    }

    public Pessoa inserir(Pessoa p) throws Exception {
        if(p.getId() == null){
            em.persist(p);
        }else{
            if(!em.contains(p)){
                if(em.find(Pessoa.class, p.getId()) == null){
                    throw new Exception("Não foi possível atualizar cadastro.");
                }
            }
            p = em.merge(p);
        }
        return p;
    }

    public Pessoa consultaPorId(Long id) {
        return em.find(Pessoa.class, id);
    }

    public void remover(Long id) {
        Pessoa p = consultaPorId(id);
        em.remove(p);
    }

}
 