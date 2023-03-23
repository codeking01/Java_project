# 基于哪个镜像构建
FROM java:8 AS builder

# 设置工作目录
WORKDIR /app

# 将Java Spring Boot项目构建结果复制到容器中
ADD ./target/pro02-springboot2-web.jar .

# 容器启动时执行的命令
CMD ["java", "-jar", "app.jar"]

# 暴露端口
EXPOSE 8080


