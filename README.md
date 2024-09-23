# Notlar

## Docker Image larını eklemek

    PostgreSQL
    userName: postgres
    password: root
    DB: AuthDB
```bash
docker run -d --name postgresql -p 5432:5432 ibrahimdoss/postgresql:v.0.1
```
    MongoDB
    userName: admin
    password: root
    DB: UserProfileDB
```bash
docker run -d --name mongodb -p 27017:27017 ibrahimdoss/mongodb:v.0.3
```

    mongod: 
    db.createUser({user: "muhammet",pwd: "root",roles: ["readWrite","dbAdmin"]}) 

## Docker üzerinde Redis Single Node oluşturmak

```bash
    docker run --name microservice-redis -p 6379:6379 -d redis
```

```bash
    docker run  --name redis-gui -d -p 8001:8001 redislabs/redisinsight:1.14.0
```

## Redis Spring Boot Configuration
    İlgili bağımlılık eklenir.

    implementation 'org.springframework.boot:spring-boot-starter-data-redis:3.2.2'

    DİKKAT!!!!
    Redis repository olarak kullanılabileceği gibi, Cache olarakta kullanılabilir, Bu nedenle Spring te Cache i 
    ve Redis Repostory aktif etmek için gerekli annotasyonları config e eklemeniz uygun olacaktır.

```java
@Configuration
@EnableRedisRepositories
@EnableCaching
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
    }

}
```

## Dockerfile ile image oluşturmak
    DİKKAT!!!!!
    1- lokalinizde çalıştırılacak imajlar için kullanım
````bash
docker build -t configserver:v01 .
````
    2- docker hub üzerinde yayınlanacak ise
````bash
docker build -t ibrahimdoss/configserver:v01 .
````
    3- Eğer M chip bir macOS var ise 
````bash
docker build --platform linux/amd64 -t ibrahimdoss/egitimconfigserver:v01 .


docker build --platform linux/amd64 -t ibrahimdoss/egitimauth:v02 .


docker build --platform linux/amd64 -t ibrahimdoss/egitimuser:v02 .

````

# Not
"proje mikroservis yapısı, google cloudda deploy, dockerize etmek gibi örnekler için olusturulmustur.
o yüzden kod kısmına çok dikkat edilmemesi lazım. 
```"
