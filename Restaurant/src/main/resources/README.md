For db connections


👉 H2 = auto everything
👉 PostgreSQL = you must create DB manually

Run as user admin:
CREATE DATABASE orders;  

In properties file:(SuoerImportant)
Change localh2 to postgres
spring.profiles.default=local
spring.profiles.default=postgres

Cleanup again run as admin
DROP TABLE orders;
