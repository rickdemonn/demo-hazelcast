##pull postgres
`docker pull postgres`

##run docker
`docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:latest`

##Add VM Options
`--add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED`
