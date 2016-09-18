# spring-ws-hibernate

1. change DataSource bean in hibernate-config.xml, f.e.

    <bean id="dataSource" class="org.apache.tomcat.dbcp.dbcp.BasicDataSource">
        <property name="driverClassName" value="org.postgresql.Driver"/>
        <property name="url" value="jdbc:postgresql://localhost:5432/postgres"/>
        <property name="username" value="postgres"/>
        <property name="password" value="12345"/>
    </bean>

2. mvn install
3. deploy sp-ws.war on Glassfish server
4. wsdl - <localhost>/sp-ws/events/events.wsdl
   ws - <localhost>/sp-ws/events