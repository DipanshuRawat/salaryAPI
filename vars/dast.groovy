def call(String zapAttackUrl, String zapReport) {
    sh "zap.sh -cmd -quickurl ${zapAttackUrl} -quickprogress -port 8091 -quickout ${zapReport}"
}
