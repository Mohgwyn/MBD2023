FROM amazoncorretto:19-alpine-jdk as build

WORKDIR /app/

COPY MDB2023-jOSEO/Main.java /app/

RUN javac Main.java

FROM amazoncorretto:19-alpine-jdk as execute

COPY --from=build /app/Main.class /app/Main.class

ENTRYPOINT ["java","Main"]