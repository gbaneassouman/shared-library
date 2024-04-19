#!/usr/bin/env groovy
/* groovylint-disable LineLength, NglParseError */
/* groovylint-disable-next-line MethodParameterTypeRequired, MethodReturnTypeRequired, NglParseError, NoDef */
// def call(dirname) {
//     sh """
//         [#!/bin/bash
//             export instance_ip=\$(cat src/terraform/${dirname}/files/infos_ec2.txt)
//             mkdir -p app-dir
//             for LINE in \$(cat /var/lib/jenkins/workspace/projet-fil-rouge/list.txt)
//             do
//                 cp -r src/"\$LINE" app-dir/
//             done
//             cp src/scripts/deploy-apps.sh app-dir/ && cp src/terraform/${dirname}/files/infos_ec2.txt app-dir/
//             zip -r app-dir.zip app-dir/
//             scp -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no -r app-dir.zip $username@$instance_ip:~/
//             ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$instance_ip 'unzip ~/app-dir.zip'
//             ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$instance_ip 'chmod +x ~/app-dir/deploy-apps.sh'
//             ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$instance_ip 'cd ~/app-dir && sh deploy-apps.sh'
//             rm -rf ~/app-*
//         ]
//     """
// }
def call(dirname) {
    sh "cat src/terraform/${dirname}/files/infos_ec2.txt"
    sh "export instance_ip=\$(cat src/terraform/${dirname}/files/infos_ec2.txt)"
    sh "mkdir -p app-dir"
    sh """
    for LINE in \$(cat /var/lib/jenkins/workspace/projet-fil-rouge/list.txt)
    do
        cp -r src/"\$LINE" app-dir/
    done
    """
    sh "cp src/scripts/deploy-apps.sh app-dir/ && cp src/terraform/${dirname}/files/infos_ec2.txt app-dir/"
    sh "zip -r app-dir.zip app-dir/"
    sh "echo ${instance_ip}"
    sh "env = env.getEnvironment()"
    //sh "println env"
    //sh "scp -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no -r app-dir.zip $username@$instance_ip:~/"
    //sh "ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$instance_ip 'unzip ~/app-dir.zip'"
    //sh "ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$instance_ip 'chmod +x ~/app-dir/deploy-apps.sh'"
    //sh "ssh -i \$TF_DIR/${dirname}/files/\$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  $username@$instance_ip 'cd ~/app-dir && sh deploy-apps.sh'"
    //sh "rm -rf ~/app-*"
}