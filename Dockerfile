FROM openjdk:8-jre-alpine
ARG BLOG_TARGET_DIR=blog/target
COPY ${BLOG_TARGET_DIR}/classes classes
COPY ${BLOG_TARGET_DIR}/lib lib
COPY ${BLOG_TARGET_DIR}/maven-archiver maven-archiver
COPY ${BLOG_TARGET_DIR}/maven-status maven-status
COPY ${BLOG_TARGET_DIR}/blog.jar blog.jar
ENTRYPOINT ["java", \
"-Xms1g", \
"-Xmx1g", \
"-Dspring.profiles.active=release", \
"-DdatabaseUrl=jdbc:mysql://133.186.223.248:13306/jaeeunyoo?useSSL=false&characterEncoding=UTF-8", \
"-DdatabaseUserName=jaeeunyoo", \
"-DdatabasePassword=Snskdi22!!", \
"-DappKey=gTX7DiXP9EsAOYpL", \
"-DsecretKey=jPG1X4bJ", \
"-Dspring.redis.port=16379", \
"-Dspring.redis.host=133.186.223.248", \
"-Dspring.redis.password=Snskdi22!!", \
"-jar", \
"/blog.jar"]