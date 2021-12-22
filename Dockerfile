FROM Temurin/openjdk17:alpine-jre

WORKDIR /usr/app
COPY build/install/nabi ./

LABEL org.opencontainers.image.source = "https://github.com/ulypse/nabi"

ENTRYPOINT ["bin/nabu"]