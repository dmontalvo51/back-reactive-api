#!/bin/sh


if ! { [ -z "$NR_APM_LICENSE_KEY" ] || [ -z "$APP_SERVICE" ] || [ -z "$APP_PACKAGE" ] || [ -z "$K8S_ENV" ]; } then
    APM_OPTS="-javaagent:newrelic.jar -Dnewrelic.config.license_key=$NR_APM_LICENSE_KEY -Dnewrelic.config.app_name=$APP_SERVICE -Dnewrelic.config.labels=env:$K8S_ENV"
elif ! { [ -z "$APM_SERVER_URL" ] || [ -z "$APP_SERVICE" ] || [ -z "$APP_PACKAGE" ]; }; then
  APM_OPTS="-javaagent:elastic-apm-agent.jar -Delastic.apm.application_packages=$APP_PACKAGE -Delastic.apm.service_name=$APP_SERVICE -Delastic.apm.server_urls=$APM_SERVER_URL"
fi

java $JAVA_OPTS $APM_OPTS -Djavax.net.ssl.trustStorePassword=changeit -Djava.security.egd=file:/dev/./urandom -jar /app.jar
