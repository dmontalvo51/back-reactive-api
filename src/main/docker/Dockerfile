FROM openjdk@sha256:85795599f4c765182c414a1eb4e272841e18e2f267ce5010ea6a266f7f26e7f6

ARG APP_SERVICE_ARG
ARG APP_PACKAGE_ARG
ENV APP_SERVICE=${APP_SERVICE_ARG}
ENV APP_PACKAGE=${APP_PACKAGE_ARG}

VOLUME /tmp
RUN export DEBIAN_FRONTEND=noninteractive \
    && apt-get update \
    && apt-get install -y --no-install-recommends \
    && apt-get install -y procps \
    && apt-get install tzdata \
	&& rm -rf /var/lib/apt/lists/*; \
	echo America/Lima > /etc/timezone; \
    rm /etc/localtime; \
	dpkg-reconfigure -fnoninteractive tzdata

ADD target/${APP_SERVICE}-app-*.jar app.jar
ADD src/main/docker/entrypoint.sh entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]