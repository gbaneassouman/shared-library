#!/usr/bin/env groovy
/* groovylint-disable GStringExpressionWithinString, LineLength, MethodReturnTypeRequired, NoDef, UnusedMethodParameter */
def install_kubernetes(String dirname) {
    /* groovylint-disable-next-line LineLength */
    if ( dirname == 'staging' ) {
        sh '''
            #!/bin/bash
            tree $TF_DIR/staging
            sleep 10
        '''
    }
    else if ( dirname == 'prod' ) {
        sh '''
            #!/bin/bash
            tree $TF_DIR/prod
            sleep 10
        '''
    }
}

/* groovylint-disable-next-line NoDef */
def deploy_apps(String dirname) {
    /* groovylint-disable-next-line DuplicateStringLiteral, EmptyIfStatement, LineLength */
    if ( dirname == 'staging') {
        sh '''
            #!/bin/bash
            ls -l $TF_DIR/staging/
        '''
    }
    /* groovylint-disable-next-line DuplicateStringLiteral */
    else if ( dirname == 'prod') {
        sh '''
            #!/bin/bash
            ls -l $TF_DIR/prod/
        '''
    }
}

//cp $TF_DIR/staging/staging.yml src/ansible/host_vars/staging.yml
//cd $PWD/src/ansible
//ansible-playbook -i hosts.yml playbooks/deploy-apps-staging.yml
//cp $TF_DIR/prod/ic-webapp-deployment.yml src/ansible/playbooks/manifests/ic-webapp/ic-webapp-deployment.yml
//cp $TF_DIR/prod/prod.yml src/ansible/host_vars/prod.yml
//cd $PWD/src/ansible
//ansible-playbook -i hosts.yml playbooks/deploy-apps-prod.yml
//src/ansible/playbooks/manifests/ic-webapp/ic-webapp-deployment.yml