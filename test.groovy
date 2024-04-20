/* groovylint-disable MethodParameterTypeRequired, MethodReturnTypeRequired, NoDef */
def execute(cmd) {
    def proc =  cmd.execute()
    proc.waitFor()
}
