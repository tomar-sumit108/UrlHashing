FROM mysql:8

ENV MYSQL_DATABASE=UrlHashingDb \
    MYSQL_ROOT_PASSWORD=root

ADD databaseSchema.sql /docker-entrypoint-initdb.d

EXPOSE 3306