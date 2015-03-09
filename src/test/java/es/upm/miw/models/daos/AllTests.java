package es.upm.miw.models.daos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.upm.miw.models.daos.jdbc.TemaDaoJdbcTest;
import es.upm.miw.models.daos.jpa.TemaDaoJpaTest;
import es.upm.miw.models.daos.jpa.VotacionDaoJpaTest;

@RunWith(Suite.class)
@SuiteClasses({TemaDaoJdbcTest.class, TemaDaoJpaTest.class, VotacionDaoJpaTest.class})
public class AllTests {

}
