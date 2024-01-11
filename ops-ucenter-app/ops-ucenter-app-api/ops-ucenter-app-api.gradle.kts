description = "用户中心API模块"

dependencies {
    api(project(":ops-common"))
    api("com.mybatis-flex:mybatis-flex-core")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}