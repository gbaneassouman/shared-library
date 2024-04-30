#!/usr/bin/env groovy
/* groovylint-disable MethodParameterTypeRequired, MethodReturnTypeRequired, NglParseError, UnusedMethodParameter */
/* groovylint-disable-next-line MethodReturnTypeRequired */
/* groovylint-disable-next-line NglParseError */
/* groovylint-disable-next-line NoDef */
def call(dirname) {
    /* groovylint-disable-next-line GStringExpressionWithinString */
    if ( dirname == 'staging' ) {
        sh '''
            #!/bin/bash
            rm -rf $AWS_KEY_NAME.pem ~/.aws
            mkdir -p ~/.aws
            echo "[default]" > ~/.aws/credentials
            echo "aws_access_key_id=$AWS_ACCESS_KEY_ID" >> ~/.aws/credentials
            echo "aws_secret_access_key=$AWS_SECRET_ACCESS_KEY" >> ~/.aws/credentials
            echo "aws_profile=$AWS_PROFILE" >> ~/.aws/credentials
            rm -rf $TF_DIR/staging/files/$AWS_KEY_NAME.pem
            cat "$AWS_PRIVATE_KEY" > $TF_DIR/staging/files/$AWS_KEY_NAME.pem
            chmod 400 $TF_DIR/staging/files/$AWS_KEY_NAME.pem
            chmod 400 ~/.aws/credentials
        '''
    }
    else if ( dirname == 'prod' ) {
        sh '''
            #!/bin/bash
            rm -rf $AWS_KEY_NAME.pem ~/.aws
            mkdir -p ~/.aws
            echo "[default]" > ~/.aws/credentials
            echo "aws_access_key_id=$AWS_ACCESS_KEY_ID" >> ~/.aws/credentials
            echo "aws_secret_access_key=$AWS_SECRET_ACCESS_KEY" >> ~/.aws/credentials
            echo "aws_profile=$AWS_PROFILE" >> ~/.aws/credentials
            rm -rf $TF_DIR/prod/files/$AWS_KEY_NAME.pem
            cat "$AWS_PRIVATE_KEY" > $TF_DIR/prod/files/$AWS_KEY_NAME.pem
            chmod 400 $TF_DIR/prod/files/$AWS_KEY_NAME.pem
            chmod 400 ~/.aws/credentials

        '''
    }
}

