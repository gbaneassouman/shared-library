#!/usr/bin/env groovy
/* groovylint-disable GStringExpressionWithinString, LineLength, NglParseError, NoDef */
/* groovylint-disable-next-line MethodParameterTypeRequired, MethodReturnTypeRequired, NglParseError, NoDef */
def call(String dirname) {
    if ( dirname == "staging" ) {
        sh '''
            #!/bin/bash
            echo staging
        '''
        }
    
    else {
        sh '''
            #!/bin/bash
            echo prod
        '''
    }
}           

