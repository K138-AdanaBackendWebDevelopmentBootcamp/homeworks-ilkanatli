# Mysql Properties
        spring.datasource.url=jdbc:mysql://localhost:3306/odev
        spring.datasource.username=root
        spring.datasource.password=1234

        spring.jpa.hibernate.ddl-auto=update
        ## Hibernate Properties
        # The SQL dialect makes Hibernate generate better SQL for the chosen database
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
        spring.jpa.properties.hibernate.show_sql=true
        spring.jpa.properties.hibernate.format_sql=true
        # data.sql Property
        #spring.sql.init.mode=always

        # for swagger
        spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER