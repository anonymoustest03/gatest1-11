import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

// This line is required to specify the DSL version.
version = "2023.11" // Or a more recent version

project {
    buildType {
        name = "My Self-Hosted Workflow"

        /*
         * This block tells TeamCity that this build can only run
         * on an agent whose name is exactly 'my-self-hosted-runner'.
         */
        requirements {
            equals("teamcity.agent.name", "my-self-hosted-runner11")
        }

        // This block defines the steps of your workflow.
        steps {
            script {
                name = "Sleep for 120 Seconds"
                scriptContent = "sleep 120"
            }
        }
    }
}
