/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.ejb;

import cadastro.modelo.Pessoa;
import javax.ejb.Remote;

/**
 *
 * @author gcamargo
 */
@Remote
public interface PessoaRemote {
    public Pessoa inserir(Pessoa p) throws Exception;
    public Pessoa consultarPorId(Long id);
    public void remover(Long id);
}
