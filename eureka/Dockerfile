# 0 bir makinede, (elimde sadece donanımlar var)
# bu projeyi çalıştırmak istesem ne yaparım?

FROM maven:3.9.9-sapmachine-23 as build

# klasör
WORKDIR /app

COPY . /app/
# Run komutu = işlem devam ederken çalıştırılır.
RUN mvn clean package -DskipTests

FROM openjdk:23-jdk

COPY --from=build /app/target/eureka-0.0.1-SNAPSHOT.jar /app/eureka.jar
# CMD komutu = image container halinde çalıştırılırken çalıştırılır.
CMD ["java", "-jar", "/app/eureka.jar"]

