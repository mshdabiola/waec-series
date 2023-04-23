
import com.android.build.api.dsl.ApplicationExtension
import com.mshdabiola.app.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
//                compileSdk=33
//                defaultConfig.targetSdk = 33
//                compileSdkPreview = "UpsideDownCake"
                defaultConfig.minSdk =24
                defaultConfig.versionName="0.0.1"
                defaultConfig.versionCode=1

                defaultConfig.testInstrumentationRunner="androidx.test.runner.AndroidJUnitRunner"
                defaultConfig.vectorDrawables{
                    useSupportLibrary=true
                }
               // defaultConfig.resourceConfigurations+= listOf("en")
               // configureFlavors(this)


            }

            tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
                kotlinOptions {
                    jvmTarget = "17"
                }
            }

        }
    }

}