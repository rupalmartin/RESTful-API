# CRUD JDBC REST API Application

Create REST endpoints for Create,Update,Delete,Read using JDBC connectivity with MYSQL DB


## REST End points

GET

```
http://localhost:8080/Rest_Demo_war/webapi/users/
```

POST

```
http://localhost:8080/Rest_Demo_war/webapi/users
```

PUT

```
http://localhost:8080/Rest_Demo_war/webapi/users/update
```

DELETE

```
http://localhost:8080/Rest_Demo_war/webapi/users/{id}
```

## Database Queries
CREATE DB 
```
create database restdb;
use restdb;
```

CREATE
```
create table restdb.users(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(40) NOT NULL,
   phone INT NOT NULL,
   PRIMARY KEY ( id )
);
```

SELECT and Insert
```
select * from restdb.users;
insert into restdb.users values(1,"Rupal","rupal@gmail.com",123);
```
