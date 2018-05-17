@echo off
@rem java -jar h2-1.4.196.jar -web -webPort 18090 -browser
call mvn exec:java
pause