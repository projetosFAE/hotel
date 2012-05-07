/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import domain.Usuarios;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alex Porto
 */
public class UsersTest extends AbstractPersistentTest {

    // Log
    private static final Logger log = LoggerFactory.getLogger(
            UsersTest.class);

    @Test
    public void Test() {
        try {
            
            //Persistence Usuário
            em.getTransaction().begin();
            Usuarios usuarios = new Usuarios();
            usuarios.setLogradouroxusuarioList(null);
            usuarios.setNiveis(null);
            usuarios.setReservasList(null);
            usuarios.setTelefonesList(null);
            usuarios.setUsuarioDocumento(null);
            usuarios.setUsuarioDocumentoTipo(null);
            usuarios.setUsuarioEmail("alex@gmail.com");
            usuarios.setUsuarioLogin("user"); 
            usuarios.setUsuarioNome("Alex de Souza Porto");
            usuarios.setUsuarioSenha("user");
            usuarios.setUsuarioxchatList(null);
            usuarios.setUsuarioDataRegistro(new Date());
            em.persist(usuarios);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
