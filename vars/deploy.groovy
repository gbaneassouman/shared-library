#!/usr/bin/env groovy
/* groovylint-disable GStringExpressionWithinString, LineLength, NglParseError, NoDef */
/* groovylint-disable-next-line MethodParameterTypeRequired, MethodReturnTypeRequired, NglParseError, NoDef */
def call(dirname) {
    sh '''
        #!/bin/bash
        echo $dirname
    '''
}           

