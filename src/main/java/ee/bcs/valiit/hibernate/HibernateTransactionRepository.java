package ee.bcs.valiit.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HibernateTransactionRepository extends JpaRepository<TransactionHibernate, String> {
}
