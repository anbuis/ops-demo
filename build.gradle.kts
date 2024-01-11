plugins {
    `maven-publish`
    `java-library`
    java
    id("org.springframework.boot") version "2.7.18"
    id("io.spring.dependency-management") version "1.1.4"
}

val modules by extra(subprojects.filter { !it.name.endsWith("mvndm") && !it.name.endsWith("bom") && !it.name.endsWith("app") })
val mvndm by extra(subprojects.filter { it.name.endsWith("mvndm") || it.name.endsWith("bom") })
val app by extra(subprojects.filter { it.name.endsWith("app") })

configure(allprojects) {
    group = "com.ops.demo"
    version = "1.0.0"

    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/nexus/content/repositories/google")
        maven("https://maven.aliyun.com/nexus/content/groups/public")
        maven("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        maven("https://mirrors.huaweicloud.com/repository/maven")
        maven("https://mirrors.cloud.tencent.com/nexus/repository/maven-public")
        maven("https://plugins.gradle.org/m2/")
        mavenCentral()
        gradlePluginPortal()
    }

    configurations.all {
        resolutionStrategy {
            cacheChangingModulesFor(0, TimeUnit.SECONDS)
            cacheDynamicVersionsFor(0, TimeUnit.SECONDS)
        }
    }
}

configure(modules) {
    apply(plugin = "maven-publish")
    apply(plugin = "java-library")
    java {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        api(platform(project(":ops-mvndm")))
        // lombok
        annotationProcessor("org.projectlombok:lombok:1.18.30")
        compileOnly("org.projectlombok:lombok:1.18.30")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
        testCompileOnly("org.projectlombok:lombok:1.18.30")
        // Hutool
        implementation("cn.hutool:hutool-all")
        // FastJson
        implementation("com.alibaba.fastjson2:fastjson2")
    }
    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    val javadocJar by tasks.registering(Jar::class) {
        archiveClassifier.set("javadoc")
    }
    val sourceJar by tasks.registering(Jar::class) {
        from(sourceSets["main"].allSource)
        archiveClassifier.set("sources")
    }
    publishing {
        publications {
            create<MavenPublication>("lib") {
                groupId = this@configure.group.toString()
                artifactId = this@configure.name
                version = this@configure.version.toString()
                from(components.getByName("java"))

                artifact(javadocJar)
                artifact(sourceJar)
            }
        }

        // 不配置默认是环境变量中配置的 M2_HOME 的 settings.xml 中配置的路径
        repositories {
            // 环境变量中配置的 M2_HOME 的 settings.xml 中配置的路径。梅有默认 USER_HOME/.m2/repository
            mavenLocal()
//            maven {
//                // 凭证
//                credentials {
//                    username = "username"
//                    password = "password"
//                }
//                // 地址
//                setUrl("https://xx.xx.xx/xxxx/xxx")
//            }
        }
    }

}

configure(mvndm) {
    apply {
        plugin("maven-publish")
    }
}

configure(app) {
    subprojects {
        apply {
            plugin("java")
            plugin("maven-publish")
            plugin("java-library")
            plugin("org.springframework.boot")
            plugin("io.spring.dependency-management")
        }

        java {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        dependencies {
            api(platform(project(":ops-mvndm")))
            implementation(project(":ops-common"))
            // lombok
            annotationProcessor("org.projectlombok:lombok:1.18.30")
            compileOnly("org.projectlombok:lombok:1.18.30")
            testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
            testCompileOnly("org.projectlombok:lombok:1.18.30")
            // Hutool
            implementation("cn.hutool:hutool-all")
            // FastJson
            implementation("com.alibaba.fastjson2:fastjson2")
        }

        configurations {
            compileOnly {
                extendsFrom(configurations.annotationProcessor.get())
            }
        }
    }

}
