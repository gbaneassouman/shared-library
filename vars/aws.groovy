#!/usr/bin/env groovy
/* groovylint-disable NglParseError */
def credentials(name) {
    /* groovylint-disable-next-line NglParseError */
    rm -rf devops-gbane.pem ~/.aws
    mkdir -p ~/.aws
    echo "[default]" > ~/.aws/credentials
    echo "aws_access_key_id=$AWS_ACCESS_KEY_ID" >> ~/.aws/credentials
    echo "aws_secret_access_key=$AWS_SECRET_ACCESS_KEY" >> ~/.aws/credentials
    echo "aws_profile=$AWS_PROFILE" >> ~/.aws/credentials
    rm -rf $TF_DIR/name/files/$AWS_KEY_NAME.pem
    cat "$AWS_PRIVATE_KEY" > $TF_DIR/name/files/$AWS_KEY_NAME.pem
    chmod 400 $TF_DIR/name/files/$AWS_KEY_NAME.pem
    chmod 400 ~/.aws/credentials
}
