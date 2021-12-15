FROM openjdk:17-jdk
RUN mkdir /bot
COPY ./build/install/bot/ /bot/
WORKDIR /bot/discord-bot/bin
CMD ["./discord-bot"]
