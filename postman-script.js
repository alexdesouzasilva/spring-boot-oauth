// Script responsável por capturar valor do token e setar na variável de ambiente do postman:

if (responseCode.code >= 200 && responseCode.code < 300) {
    var json = JSON.parse(responseBody);
    postman.setEnvironmentVariable('token', json.access_token);
}