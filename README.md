# projeto-jsf-jakartaee - Postgresql - Configuração Intelij
1. Configurar standalone.xml - wildfly -preview 26.0.1.Final jakarta 9.1
> <subsystem xmlns="urn:jboss:domain:datasources:7.0">
            <datasources>
                <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=${wildfly.h2.compatibility.mode:REGULAR}</connection-url>
                    <driver>h2</driver>
                    <security>
                        <user-name>sa</user-name>
                        <password>sa</password>
                    </security>
                </datasource>
                <datasource jta="true" jndi-name="java:jboss/datasources/portalDS" pool-name="portalDS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:postgresql://localhost:5432/portal</connection-url>
                    <driver>postgresql</driver>
                    <security>
                        <user-name>postgres</user-name>
                        <password>MainUser</password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                    <driver name="postgresql" module="org.postgresql">
                        <driver-class>org.postgresql.Driver</driver-class>
                    </driver>
                </drivers>
            </datasources>
        </subsystem> 
<br>

2. module.xml: deixar na pasta - ~/wildfly-29.0.1.Final/modules/system/layers/base/org/postgresql/main, além de baixar o jar do postgres
> <module xmlns="urn:jboss:module:1.1" name="org.postgresql">
    <resources>
        <resource-root path="postgresql-42.7.3.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>

<br>

3. Dentro da pasta deve ter o module.xml  postgresql-42.7.3.jar

<br>

4. Pra rodar o debug add no standalone.conf
   >Sample JPDA settings for remote socket debugging
   >>JAVA_OPTS="$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,address=8787,server=y,suspend=n"