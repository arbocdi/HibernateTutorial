package kg.arbocdi.hibernatetutorial;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author arbocdi
 */
public class Launcher {

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
        Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
        System.setProperty("java.naming.factory.url.pkgs", "org.eclipse.jetty.jndi");
        System.setProperty("java.naming.factory.initial", "org.eclipse.jetty.jndi.InitialContextFactory");
        HikariConfig config = new HikariConfig("config/hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        InitialContext ctx = new InitialContext();
        ctx.bind("pgPool", ds);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("company");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
//        Log log = new Log();
//        log.setDescr("arboc login in");
//        Query query = em.createQuery(" SELECT u FROM User u WHERE u.name = :name");
//        query.setParameter("name", "arboc");
//        User arboc = (User) query.getSingleResult();
//        System.out.println(arboc);
//        Query query2 = em.createQuery(" SELECT a FROM Action a WHERE a.descr = :descr");
//        query2.setParameter("descr", "login");
//        Action login = (Action) query2.getSingleResult();
//        System.out.println(login);
//        log.setUser(arboc);
//        log.setAction(login);
//        em.persist(log);
        
        Query query = em.createQuery(" SELECT u FROM User u WHERE u.name = :name");
        query.setParameter("name", "dhurva");
        User arboc = (User) query.getSingleResult();
        //arboc.setId(10);
        em.getTransaction().commit();
        
        em.close();
    }
}
