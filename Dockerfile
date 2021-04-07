#Build Java Application
FROM openjdk:8-jre-alpine

LABEL maintainer="hbpro2001@gmail.com"

#set environment properties for jvm configuration
ENV JAVA_OPTS '-Xmx256m -Xms256m'
ENV DIUS_BOWLING_GAME_HOME '/usr/src/app/dius_bowling_game'

# set configurable user group
ARG UNAME=dius
ARG UID=860
ARG GID=860
ARG USER_HOME=/usr/src/app/dius_bowling_game

# create directories and set permissions
RUN mkdir -p -m a=rwx $USER_HOME/resources

# create user group and user
RUN addgroup --gid "$GID" "$UNAME" \
    && adduser \
    --disabled-password \
    --gecos "" \
    --home "$USER_HOME" \
    --ingroup "$UNAME" \
    --uid "$UID" \
    --shell /bin/sh "$UNAME"

# setting workdir
WORKDIR $USER_HOME

# switch user and set environment
USER $UNAME

# copy app contents
COPY --chown=860:860 target/dius-bowling-1.jar $USER_HOME

# entrypoint script
ENTRYPOINT exec java $JAVA_OPTS -jar dius-bowling-1.jar
