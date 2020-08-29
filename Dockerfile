FROM clojure:openjdk-11-lein as builder

WORKDIR /showcase
COPY . .
RUN lein uberjar

FROM alpine:3

WORKDIR /showcase
COPY --from=builder /showcase/target/uberjar/clojure-showcase-1.0.5-standalone.jar ./showcase.jar

RUN apk add openjdk11-jre --no-cache

CMD java -jar ./showcase.jar