#!/usr/bin/env groovy
/* groovylint-disable MethodParameterTypeRequired, MethodReturnTypeRequired, NoDef */
def init(dirname) {
    'cd src/terraform/dirname'
    'terraform init -input=false'
}

def plan(dirname) {
    'cd src/terraform/dirname'
    'terraform plan - out dirname.plan'
}

/* groovylint-disable-next-line MethodParameterTypeRequired */
def apply(dirname) {
    'cd src/terraform/dirname'
    'terraform apply dirname.plan'
}

