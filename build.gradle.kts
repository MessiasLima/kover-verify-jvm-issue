import kotlinx.kover.gradle.plugin.dsl.AggregationType
import kotlinx.kover.gradle.plugin.dsl.CoverageUnit

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kover)
}

dependencies {
    kover(project(":composeApp"))
}

kover {
    reports {
        filters {
            excludes {
                classes(
                    "Res*",
                )

                packages("is_cidadao.compose.generated.resources")
            }
        }

        verify {
            rule {
                bound {
                    minValue = 100
                    coverageUnits = CoverageUnit.LINE
                    aggregationForGroup = AggregationType.COVERED_PERCENTAGE
                }

                bound {
                    minValue = 100
                    coverageUnits = CoverageUnit.INSTRUCTION
                    aggregationForGroup = AggregationType.COVERED_PERCENTAGE
                }

                bound {
                    minValue = 100
                    coverageUnits = CoverageUnit.BRANCH
                    aggregationForGroup = AggregationType.COVERED_PERCENTAGE
                }
            }
        }
    }
}