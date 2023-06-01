package br.com.fdte.firstproject.repositories;

import br.com.fdte.firstproject.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    /*
    User findByEmail(String email);

    List<Pessoa> findByEmail(String email);

    // custom query example and return a stream
    @Query("select c from Customer c where c.email = :email")
    Stream<Pessoa> findByEmailReturnStream(@Param("email") String email);

    @Query("SELECT COUNT(u.id) FROM User u WHERE u.email=:email) Long
    countUsersWithEmail(String email);

    queries dinâmicas
    public Pessoa buscaUsuarioPorEmail(String email) {
    String jpql = "select u from Usuario u where u.email = :email";
    return this.manager
        .createQuery(jpql, Usuario.class)
        .setParameter("email", email)
        .getSingleResult();
    }

    SELECT email FROM pessoa WHERE pessoa.email LIKE '%' || :email || '%'
    .setParameter("email", email)
    .getSingleResult();
    */

    //EntityManager em = entityManagerFactory.createEntityManager();
    //Query query = em.createQuery(
      //      "SELECT e FROM Employee e WHERE e.dept LIKE '%@_%' ESCAPE '@'");
    //List<Employee> resultList = query.getResultList();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpersiste");
    EntityManager em = emf.createEntityManager();

    String jpql = ("select c from Pessoa c where c.agencia like :pAgencia");

    Query query = em.createQuery(jpql);

    String valorParametro = "123";
    //query.setParameter("pAgencia", "%" + valorParametro + "%");
    List<Pessoa> pessoa = query.getResultList();


}
