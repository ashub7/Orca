import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.module.graph) apply true
}

val detektFormatting = libs.detekt.formatting

allprojects {
    apply {
        plugin("io.gitlab.arturbosch.detekt")
    }

    dependencies {
        detektPlugins(detektFormatting)
        detektPlugins("com.twitter.compose.rules:detekt:0.0.26")
    }
    val configFile = files("$rootDir/config/detekt/detekt.yml")
    detekt {
        ignoreFailures = true
        parallel = true
        config.setFrom(configFile)
        buildUponDefaultConfig = true
        toolVersion = "1.23.3"
        allRules = true
        baseline = file("detekt/baseline.xml")
        basePath = projectDir.absolutePath
    }

    tasks.withType<Detekt>().configureEach {
        jvmTarget = "1.8"
        reports {
            xml.required = false
            html.required = true
            html.outputLocation = file("detekt/report.html")
            txt.required = false
            sarif.required = false
            md.required = false
        }
        basePath = rootDir.absolutePath
    }
}

/*tasks.whenTaskAdded {
    if (name == "compileDebugKotlin") {
        dependsOn(tasks.detekt)
        mustRunAfter(tasks.detekt)
    }
}*/

moduleGraphConfig {
    readmePath.set("./README.md")
    heading = "### Module Graph"
    // showFullPath.set(false) // optional
    // orientation.set(Orientation.LEFT_TO_RIGHT) //optional
    // linkText.set(LinkText.NONE) // optional
    // setStyleByModuleType.set(true) // optional
    // excludedConfigurationsRegex.set(".*test.*") // optional
    // excludedModulesRegex.set(".*moduleName.*") // optional
    // focusedModulesRegex.set(".*(projectName).*") // optional
    // rootModulesRegex.set(".*moduleName.*") // optional
    // theme.set(Theme.NEUTRAL) // optional
    // or you can fully customize it by using the BASE theme:
    // Theme.BASE(
    //     themeVariables = mapOf(
    //         "primaryTextColor" to "#F6F8FAff", // Text
    //         "primaryColor" to "#5a4f7c", // Node
    //         "primaryBorderColor" to "#5a4f7c", // Node border
    //         "tertiaryColor" to "#40375c", // Container box background
    //         "lineColor" to "#f5a623",
    //         "fontSize" to "12px",
    //     ),
    //     focusColor = "#F5A622",
    //     moduleTypes = listOf(
    //         ModuleType.AndroidLibrary("#2C4162"),
    //     )
    // ),
    // )

    // You can add additional graphs.
    // A separate graph will be generated for each config below.
    // graph(
    //     readmePath = "./README.md",
    //     heading = "# Graph with root: gama",
    // ) {
    //     rootModulesRegex = ".*gama.*"
    // }
    // graph(
    //     readmePath = "./SomeOtherReadme.md",
    //     heading = "# Graph",
    // ) {
    //     rootModulesRegex = ".*zeta.*"
    // }
}


