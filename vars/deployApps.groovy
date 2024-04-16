#!/usr/bin/env groovy
/* groovylint-disable LineLength, NglParseError */
def exportIp(dirname) {
    "export instance_ip=$(awk '{print $1}' src/terraform/dirname/files/infos_ec2.txt)"
}

/* groovylint-disable-next-line NglParseError */
def createDir(dirname) {
    """
    INFILE=$PWD/list.txt
    mkdir -p app-dir
    for LINE in $(cat "$INFILE")
    do
        cp -r src/"$LINE" app-dir/
    done
    """
}

def copyFile(dirname) {
    "cp src/scripts/deploy-apps.sh app-dir/ && cp src/terraform/dirname/files/infos_ec2.txt app-dir/"
    "zip -r app-dir.zip app-dir/"
    'scp -i $TF_DIR/dirname/files/$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no -r app-dir.zip ${username}@$instance_ip:~/"'
}

def deployApps(dirname) {
    'ssh -i $TF_DIR/dirname/files/$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  ${username}@$instance_ip "unzip ~/app-dir.zip"'
    'ssh -i $TF_DIR/dirname/files/$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  ${username}@$instance_ip "chmod +x ~/app-dir/deploy-apps.sh"'
    'ssh -i $TF_DIR/dirname/files/$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  ${username}@$instance_ip "cd ~/app-dir && sh deploy-apps.sh"'
}

def unzipDir(dirname) {
    'ssh -i $TF_DIR/dirname/files/$AWS_KEY_NAME.pem -o StrictHostKeyChecking=no  ${username}@$instance_ip "unzip ~/app-dir.zip"'
}

def deleteDirs(dirname) {
    "rm -rf ~/app-dir ~/app-dir.zip"
}
