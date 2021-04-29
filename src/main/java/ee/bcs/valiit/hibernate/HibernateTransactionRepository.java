package ee.bcs.valiit.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HibernateTransactionRepository extends JpaRepository<TransactionHibernate, Integer> {

    List<TransactionHibernate> findByIban(String iban);
}
