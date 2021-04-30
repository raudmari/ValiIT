package ee.bcs.valiit.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HibernateLoginRepository extends JpaRepository<LoginHibernate, Integer> {

    LoginHibernate findByUsername (String username);
}
