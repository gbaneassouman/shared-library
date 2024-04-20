#!/usr/bin/env groovy
import hudson.EnvVars;
import jenkins.model.Jenkins
/* groovylint-disable GStringExpressionWithinString, LineLength, NglParseError, NoDef */
/* groovylint-disable-next-line MethodParameterTypeRequired, MethodReturnTypeRequired, NglParseError, NoDef */
// def call(dirname) {
//     sh """
//         [#!/bin/bash
//             export INSTANCE=\$(cat src/terraform/${dirname}/files/infos_ec2.txt)
//             mkdir -p app-dir
//             for LINE in \$(cat /var/lib/jenkins/workspace/projet-fil-rouge/list.txt)
//             do
//                 cp -r src/"\$LINE" app-dir/
//             done
//             cp src/scripts/deploy-apps.sh app-dir/ && cp src/terraform/${dirname}/files/infos_ec2.txt app-dir/
//             zip -r app-dir.zip app-dir/
//             scp -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no -r app-dir.zip $username@$INSTANCE:~/
//             ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$INSTANCE 'unzip ~/app-dir.zip'
//             ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$INSTANCE 'chmod +x ~/app-dir/deploy-apps.sh'
//             ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$INSTANCE 'cd ~/app-dir && sh deploy-apps.sh'
//             rm -rf ~/app-*
//         ]
//     """
// }
/* groovylint-disable-next-line MethodParameterTypeRequired, MethodReturnTypeRequired */
def call(dirname) {
    sh 'curl https://checkip.amazonaws.com'
    sh 'export INSTANCE=\$(cat src/terraform/${dirname}/files/infos_ec2.txt)'
    def env = System.getenv()
    echo env['JENKINS_HOME']
    sh 'mkdir -p app-dir'
    sh """
    for LINE in \$(cat /var/lib/jenkins/workspace/projet-fil-rouge/list.txt)
    do
        cp -r src/"\$LINE" app-dir/
    done
    """
    //sh 'cp src/scripts/deploy-apps.sh app-dir/ && cp src/terraform/${dirname}/files/infos_ec2.txt app-dir/'
    //sh 'zip -r app-dir.zip app-dir/'
    //sh "scp -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no -r app-dir.zip $username@$INSTANCE:~/"
    //sh "ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$INSTANCE 'unzip ~/app-dir.zip'"
    //sh "ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$INSTANCE 'chmod +x ~/app-dir/deploy-apps.sh'"
    //sh "ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$INSTANCE 'cd ~/app-dir && sh deploy-apps.sh'"
    //sh 'rm -rf ~/app-*'
}
