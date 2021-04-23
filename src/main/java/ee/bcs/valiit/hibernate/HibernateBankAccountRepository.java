package ee.bcs.valiit.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
                            /// hibernate classi annotatsioon ja primaarvõtme andme tüüp on JpaRepository sees
public interface HibernateBankAccountRepository extends JpaRepository<BankAccountHibernate, String> {
}
