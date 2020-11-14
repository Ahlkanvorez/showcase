FROM clojure:openjdk-16-lein-slim-buster as builder

WORKDIR /showcase
COPY . .
RUN lein uberjar

FROM openjdk:16-slim-buster

EXPOSE 3000
WORKDIR /showcase

CMD ["java", \
     "-XX:+UseContainerSupport", \
     "-XX:+UnlockExperimentalVMOptions", \
     "-XX:+UseZGC", \
     "-jar", \
     "./showcase.jar"]

COPY --from=builder /showcase/resources ./resources
COPY --from=builder /showcase/target/uberjar/clojure-showcase-*-standalone.jar ./showcase.jar