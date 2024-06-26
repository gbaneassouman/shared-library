#!/usr/bin/env groovy
/* groovylint-disable GStringExpressionWithinString, LineLength, MethodReturnTypeRequired, NoDef, UnusedMethodParameter */
def install_kubernetes(String dirname) {
    /* groovylint-disable-next-line LineLength */
    if ( dirname == 'staging' ) {
        sh '''
            #!/bin/bash
            cp $TF_DIR/staging/staging.yml src/ansible/host_vars/staging.yml
            cp $TF_DIR/staging/ic-webapp-deployment.yml src/ansible/playbooks/manifests/ic-webapp/ic-webapp-deployment.yml
            cd $PWD/src/ansible
            ansible-playbook -i hosts.yml playbooks/staging-k3s.yml
        '''
    }
    else if ( dirname == 'prod' ) {
        sh '''
            #!/bin/bash
            cp $TF_DIR/prod/ic-webapp-deployment.yml src/ansible/playbooks/manifests/ic-webapp/ic-webapp-deployment.yml
            cp $TF_DIR/prod/prod.yml src/ansible/host_vars/prod.yml
            cd $PWD/src/ansible
            ansible-playbook -i hosts.yml playbooks/prod-k3s.yml
        '''
    }
}

/* groovylint-disable-next-line NoDef */
def deploy_apps(String dirname) {
    /* groovylint-disable-next-line DuplicateStringLiteral, EmptyIfStatement, LineLength */
    if ( dirname == 'staging') {
        sh '''
            #!/bin/bash
            cp $TF_DIR/staging/staging.yml src/ansible/host_vars/staging.yml
            cp $TF_DIR/staging/ic-webapp-deployment.yml src/ansible/playbooks/manifests/ic-webapp/ic-webapp-deployment.yml
            cd $PWD/src/ansible
            ansible-playbook -i hosts.yml playbooks/deploy-apps-staging.yml
        '''
    }
    /* groovylint-disable-next-line DuplicateStringLiteral */
    else if ( dirname == 'prod') {
        sh '''
            #!/bin/bash
            cp $TF_DIR/prod/ic-webapp-deployment.yml src/ansible/playbooks/manifests/ic-webapp/ic-webapp-deployment.yml
            cp $TF_DIR/prod/prod.yml src/ansible/host_vars/prod.yml
            cd $PWD/src/ansible
            ansible-playbook -i hosts.yml playbooks/deploy-apps-prod.yml
        '''
    }
}
