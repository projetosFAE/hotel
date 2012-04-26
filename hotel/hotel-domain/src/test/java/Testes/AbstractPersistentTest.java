/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.BeforeClass;

/**
 *
 * @author Alex Porto
 */
public abstract class AbstractPersistentTest {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    public AbstractPersistentTest() {
        em = getEntityManager();
    }

    @BeforeClass
    public static void setup() {
        emf = Persistence.createEntityManagerFactory("hotelPU");

    }

    protected static EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }
    
    private static Random rand = new Random();
    private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÃÕÂÊÎÔÛÀÈÌÒÙÇ".toCharArray();

    public static String ramdomName(int nCaracteres) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nCaracteres; i++) {
            int ch = rand.nextInt(letras.length);
            sb.append(letras[ch]);
        }
        return sb.toString();
    }
}
