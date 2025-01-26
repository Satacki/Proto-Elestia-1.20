import java.net.URI

plugins {
    id("fabric-loom") version "1.9-SNAPSHOT"
    id("maven-publish")
}

version = "mod_version"()
group = "maven_group"()

base {
    archivesName = "archives_base_name"()
}

repositories {
    maven("https://maven.blamejared.com")
    maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
    maven("https://maven.parchmentmc.org")
    maven("https://pkgs.dev.azure.com/djtheredstoner/DevAuth/_packaging/public/maven/v1")


}

fabricApi {
    configureDataGeneration()
}

dependencies {
    minecraft("com.mojang:minecraft:${"minecraft_version"()}")

    @Suppress("UnstableApiUsage")
    mappings(loom.layered {
        officialMojangMappings()
        parchment("org.parchmentmc.data:parchment-${"minecraft_version"()}:${"parchment_version"()}@zip")
    })

    modImplementation("net.fabricmc:fabric-loader:${"fabric_version"()}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${"fabric_api_version"()}")
    modImplementation("software.bernie.geckolib:geckolib-fabric-${"minecraft_version"()}:${"geckolib_version"()}")
    modImplementation("foundry.veil:Veil-fabric-${"minecraft_version"()}:${"veil_version"()}")

    implementation("com.eliotlash.mclib:mclib:20")

    // This is dev only, just logs you in when you `runClient`.
    modRuntimeOnly("me.djtheredstoner:DevAuth-fabric:${"devauth_version"()}")
}

tasks.processResources {
    val props = mapOf(
        "mod_id" to "mod_id"(),
        "version" to "mod_version"()
    )

    inputs.properties(props)

    filesMatching(listOf("fabric.mod.json")) {
        expand(props)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 17
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName.get()}" }
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    repositories {
    }
}

// On every project I steal this same one-liner from RDH
// It's amazing
operator fun String.invoke(): String = rootProject.ext[this] as? String ?: error("No property \"$this\"")
