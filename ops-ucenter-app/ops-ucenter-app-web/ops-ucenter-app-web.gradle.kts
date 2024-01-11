description = "用户服务WEB服务"

dependencies {
    implementation(project(":ops-ucenter-app:ops-ucenter-app-api"))
    // 支持 bootstrap.yml 配置文件
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    // Web 配置
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    // SpringDoc
    implementation("com.github.xiaoymin:knife4j-openapi3-spring-boot-starter")
    // JDBC
    implementation("com.mybatis-flex:mybatis-flex-spring-boot-starter")
//    implementation("org.mybatis:mybatis-typehandlers-jsr310")
    // MySQL
    implementation("org.postgresql:postgresql")
    // Junit Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}