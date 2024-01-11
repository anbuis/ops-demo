description = "统一依赖版本定义"

plugins {
    `java-platform`
}

javaPlatform {
    allowDependencies()
}

extra.set("springBootVersion", "2.7.18")
extra.set("springCloudVersion", "2021.0.8")
extra.set("springCloudAlibabaVersion", "2021.1")
extra.set("dubboVersion", "3.2.8")
extra.set("knife4jVersion", "4.3.0")
extra.set("lombokVersion", "1.18.30")
extra.set("hutoolVersion", "5.8.23")
extra.set("fastjson2Version", "2.0.42")
extra.set("okhttpVersion", "4.12.0")
extra.set("easyExcelVersion", "3.3.2")
extra.set("mysqlVersion", "8.0.33")
extra.set("lombokVersion", "1.18.30")
extra.set("mybatisPlusVersion", "3.5.3.2")
extra.set("jodaTimeVersion", "2.12.5")
extra.set("xxlJobVersion", "2.4.0")
extra.set("springdocVersion", "1.7.0")
extra.set("postgresqlVersion", "42.7.0")
extra.set("mybatisFlexVersion", "1.7.5")
extra.set("mybatisFlexKotlinVersion", "1.0.3")
extra.set("hikariVersion", "4.0.3")
extra.set("mybatisTypeHandlersVersion", "1.0.2")

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:${project.ext["springBootVersion"]}"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:${project.ext["springCloudVersion"]}"))
    api(platform("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${project.ext["springCloudAlibabaVersion"]}"))
    api(platform("org.apache.dubbo:dubbo-bom:${project.ext["dubboVersion"]}"))
    api(platform("org.apache.dubbo:dubbo-dependencies-zookeeper-curator5:${project.ext["dubboVersion"]}"))
    api(platform("com.github.xiaoymin:knife4j-dependencies:${project.ext["knife4jVersion"]}"))
    api(platform("com.mybatis-flex:mybatis-flex-dependencies:${project.ext["mybatisFlexVersion"]}"))
    constraints {
        api("cn.hutool:hutool-all:${project.ext["hutoolVersion"]}")
        api("com.alibaba.fastjson2:fastjson2:${project.ext["fastjson2Version"]}")
        api("com.squareup.okhttp3:okhttp:${project.ext["okhttpVersion"]}")
        api("com.alibaba:easyexcel:${project.ext["easyExcelVersion"]}")
        api("com.mysql:mysql-connector-j:${project.ext["mysqlVersion"]}")
        api("org.projectlombok:lombok:${project.ext["lombokVersion"]}")
        api("com.baomidou:mybatis-plus-boot-starter:${project.ext["mybatisPlusVersion"]}")
        api("joda-time:joda-time:${project.ext["jodaTimeVersion"]}")
        api("com.xuxueli:xxl-job-core:${project.ext["xxlJobVersion"]}")
        api("org.springdoc:springdoc-openapi-ui:${project.ext["springdocVersion"]}")
        runtime("org.postgresql:postgresql:${project.ext["postgresqlVersion"]}")
        api("com.zaxxer:HikariCP:${project.ext["hikariVersion"]}")
        api("com.mybatis-flex:mybatis-flex-kotlin-extensions:${project.ext["mybatisFlexKotlinVersion"]}")
        api("com.mybatis-flex:mybatis-flex-processor:${project.ext["mybatisFlexVersion"]}")
        api("org.mybatis:mybatis-typehandlers-jsr310:${project.ext["mybatisTypeHandlersVersion"]}")
    }
}

publishing {
    publications {
        create<MavenPublication>("bom") {
            groupId = "${project.group}"
            artifactId = "${project.name}-bom"
            version = "${project.version}"
            from(components.getByName("javaPlatform"))

            pom {
                packaging = "pom"
                name.set("${project.name}-bom")
                description.set("BOM 依赖版本定义")

                developers {
                    developer {
                        name.set("Anbuis")
                        email.set("1577123083@qq.com")
                        roles.set(listOf("Java Development Engineer", "Kotlin Development Engineer"))
                    }
                }
            }
        }
    }
}