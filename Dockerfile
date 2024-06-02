FROM openjdk:11-jre-slim
WORKDIR /app
COPY . /app
RUN testng.xml
CMD ["xml","testng"]
