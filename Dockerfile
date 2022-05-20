FROM openjdk:17-alpine

COPY ./output/ /app
WORKDIR /app
ENV MYSQL_ROOT_PASSWORD=root

#CMD["java","-jar","/app/demo-v2.8.jar"]
ENTRYPOINT [ \
    "java", \
    "-jar", \
    "/app/smart-city-1.2-SNAPSHOT-jar-with-dependencies.jar" \
]