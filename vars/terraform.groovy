#!/usr/bin/env groovy
/* groovylint-disable MethodParameterTypeRequired, MethodReturnTypeRequired, NoDef, UnusedMethodParameter */

def init(dirname) {
    /* groovylint-disable-next-line GStringExpressionWithinString */
    sh '''
        cd src/terraform/${dirname}
        terraform init -input=false
    '''
}

def plan(dirname) {
    /* groovylint-disable-next-line GStringExpressionWithinString */
    sh '''
        cd src/terraform/${dirname}
        terraform plan - out ${dirname}.plan
    '''
}

/* groovylint-disable-next-line GStringExpressionWithinString, MethodParameterTypeRequired */
def apply(dirname) {
    /* groovylint-disable-next-line GStringExpressionWithinString */
    sh '''
        cd src/terraform/${dirname}
        terraform apply ${dirname}.plan
    '''
}

