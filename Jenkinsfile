node {
    stage 'Clone the project'
    git 'https://github.com/nick2202/coop-list/'

    dir('coop-list') {
        stage("Compilation and Analysis") {
            parallel 'Compilation': {
                    bat "./mvnw.cmd clean install -DskipTests"
            }
        }

        stage("Tests and Deployment") {
            parallel 'Unit tests': {
                stage("Running unit tests") {
                    try {
                            bat "./mvnw.cmd test -Punit"
                    } catch(err) {
                        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*UnitTest.xml'])
                        throw err
                    }
                    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*UnitTest.xml'])

                }
            },
            stage("Staging") {
                    bat "FOR /F \"tokens=5 delims= \" %%G IN (\"netstat -a | findstr :8989\") DO TaskKill.exe /PID %%G /fi \"memusage gt 0\""

                withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                   bat 'start mvnw.cmd spring-boot:run -Dserver.port=8080'
                }
            }
        }
    }
}