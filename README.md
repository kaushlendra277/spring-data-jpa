# spring-data-jpa
<br>
#### JPA - Java Persistence API 
<br>
It is the specification that lets us do ORM  when app connects to RDBMS.
<br>
#### ORM - Object Relational Mapping
<br>
ORM lets the mapping from entity(i.e.POJO) classes to table in the db, JPA is the way to leverage ORM in java.
<br>

##### Steps to add use spring-data-jpa using spring boot
<br>
1. Add maven dependency for spring-boot-data-jpa-starter and db dependency
<br>
2. Mark models as @Entity - [This tells that the object of this class is to be mapped/saved to the db ]
<br>
	- once spring app bootstrap it reads this annotation and creates table as per the specified name
	<br>
	- name of column and its data is same as field name to @entity marked class

3. [MUST] Mark the entity field as @Id to make it primary column

4. Create a interface XyzRepository and extends <spring-provided-repository>[NO NEED TO ANNOTATE @Repository bad practice]
<br>
e.g. of <spring-provided-repository> = CrudRepository<T, PK_DATA_TYPE>
<br>
where T = Entity type eg, Student, User etc.
<br>
PK_DATA_TYPE = data type of @Id mrkedfield of Entity eg, String, Integer, Long etc.
<br>
5. Inject  bean XyzRepository within  @Service [EVEN THOUGH XyzRepository is an interface Spring create a bean internally since we exends  <spring-provided-repository>]
<br>
6 use the bean to call methods of XyzRepository

<br>
##### Note :
<br>
1. Since me marked primarykey as @Id in our entity we need to pass id as well to insert a record.
<br>
But is not good practice Use @GeneratedValue with @Id to autogenerate PK as @GeneratedValue(strategy = GenerationType.SEQUENCE)
<br>

2. If we have only one embedded db jars in our class path then we don't need to tell Spring boot about db connection
<br>
Spring boot auto auto detect and connect to the db.