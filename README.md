# spring-jta-narayana
Spring project with JTA, JPA, Hibernate and Narayana

At first, this project was a typical project with Spring JPA (and Hibernate) for MySQL DB with transactions.

But now, this project was converted to use JTA and Narayana.

Changes to convert this project:

1. Add dependencies to pom.xml: spring-tx, jta, jbossjta and narayana-jta.
2. Change MySQL driver to XA implementation support.
3. Add to applicationContext.xml transactionManager references and comment old transactionManager setting.
4. To indicate transaction-manager in tx:annotation-driven in applicationContext.xml.

Additionally contains: Log4J (according to: http://spring.io/blog/2009/12/04/logging-dependencies-in-spring/)
