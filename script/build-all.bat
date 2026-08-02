@echo off

echo ===============================
echo Stopping old containers...
echo ===============================
cd docker-compose
docker compose -f docker-compose\docker-compose.yml down

echo ===============================
echo Removing old images...
echo ===============================
docker rmi -f kartik/order:v1
docker rmi -f kartik/payment:v1
docker rmi -f kartik/audit:v1
docker rmi -f kartik/eureka:v1
cd ..

echo ===============================
echo Building Eureka Server...
echo ===============================
cd eurekaServer
call .\mvnw.cmd clean package -DskipTests jib:dockerBuild
cd ..

echo ===============================
echo Building Order Service...
echo ===============================
cd order
call mvnw.cmd clean package -DskipTests jib:dockerBuild
cd ..

echo ===============================
echo Building Payment Service...
echo ===============================
cd payment
call mvnw.cmd clean package -DskipTests jib:dockerBuild
cd ..

echo ===============================
echo Building Audit Service...
echo ===============================
cd audit
call mvnw.cmd clean package -DskipTests jib:dockerBuild
cd ..

echo ===============================
echo Building API Gateway Service...
echo ===============================
cd gatewayserver
call mvnw.cmd clean package -DskipTests jib:dockerBuild
cd ..

echo ===============================
echo Starting Containers...
echo ===============================
docker compose -f docker-compose\docker-compose.yml up -d

echo ===============================
echo Done!
echo ===============================
pause