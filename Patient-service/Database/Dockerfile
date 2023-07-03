# syntax=docker/dockerfile:1
FROM mysql:8.0.31

ENV MYSQL_DATABASE=mediscreenpatient \
    MYSQL_ROOT_PASSWORD=rootroot

ADD initdb.sql /docker-entrypoint-initdb.d