rem batch test
echo A4 batch test
echo username:%USERNAME%
echo CD

start "mysql" cmd /k mysql_start
timeout 5

cd rank-spring
call mvn clean package -q
call java -jar target/rank-spring.jar
call mvn clean -q

call cd ../ms-spring-boot
call mvn clean package -q
start "ms-spring-boot" cmd /k java -jar target/ms-spring-boot.jar
timeout 10

call curl http://localhost:8080/grade/76
echo ""
call curl http://localhost:8080/rank/76
echo ""
call curl http://localhost:8080/predict/3198,9669,5,1,1,0

call taskkill /FI "WindowTitle eq ms-spring-boot*"  /T /F  >null

start "karaf" cmd /k karaf
timeout 10

cd ../stats-osgi-service
call mvn clean install -q
call xcopy target\stats-osgi-service.jar  %ENTERPRISE%\apache-karaf-4.3.0\deploy  /Y

cd ../stats-osgi-consumer
call mvn clean package -q
call xcopy target\stats-osgi-consumer.jar  %ENTERPRISE%\apache-karaf-4.3.0\deploy  /Y

cd ../stats-osgi-web
call mvn clean package -q
call xcopy target\stats-osgi-web.jar  %ENTERPRISE%\apache-karaf-4.3.0\deploy  /Y

timeout 5
call curl http://localhost:8181/stats-osgi-web?query=count
call curl http://localhost:8181/stats-osgi-web?query=mean

call del /F %ENTERPRISE%\apache-karaf-4.3.0\deploy\stats-osgi-web.jar
call del /F %ENTERPRISE%\apache-karaf-4.3.0\deploy\stats-osgi-consumer.jar
call del /F %ENTERPRISE%\apache-karaf-4.3.0\deploy\stats-osgi-service.jar

cd ../stats-osgi-service
call mvn clean -q

cd ../stats-osgi-consumer
call mvn clean -q

cd ../stats-osgi-web
call mvn clean -q

cd ..

taskkill /FI "WindowTitle eq karaf"  /T /F >null
taskkill /FI "WindowTitle eq mysql*"  /T /F >null

echo END
