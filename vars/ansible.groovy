#!/usr/bin/env groovy
/* groovylint-disable GStringExpressionWithinString, LineLength, MethodReturnTypeRequired, NoDef, UnusedMethodParameter */
def install_kubernetes(String dirname) {
    /* groovylint-disable-next-line LineLength */
    sh '''
        #!/bin/bash
        cp $TF_DIR/${dirname}/ic-webapp-deployment.yml src/ansible/playbooks/manifests/ic-webapp/ic-webapp-deployment.yml
        cp $TF_DIR/${dirname}/${dirname}.yml src/ansible/host_vars/${dirname}.yml
        cd $PWD/src/ansible
        ansible-playbook -i hosts.yml playbooks/${dirname}-k3s.yml
        sleep 10
    '''
}

/* groovylint-disable-next-line NoDef */
def deploy_apps(String dirname) {
    /* groovylint-disable-next-line LineLength */
    sh '''
        #!/bin/bash
        cp $TF_DIR/${dirname}/ic-webapp-deployment.yml src/ansible/playbooks/manifests/ic-webapp/ic-webapp-deployment.yml
        cp $TF_DIR/${dirname}/${dirname}.yml src/ansible/host_vars/${dirname}.yml
        cd $PWD/src/ansible
        ansible-playbook -i hosts.yml playbooks/deploy-apps-${dirname}.yml
    '''
}
