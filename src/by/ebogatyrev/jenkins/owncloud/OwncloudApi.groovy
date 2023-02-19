package by.ebogatyrev.jenkins.owncloud

import by.ebogatyrev.jenkins.owncloud.converter.CreateShareResponseConverter
import by.ebogatyrev.jenkins.owncloud.model.share.CreateShareRequest
import groovy.transform.Synchronized

class OwncloudApi {
    private String baseUrl;
    private String authToken;

    OwncloudApi(String baseUrl, String authToken) {
        this.baseUrl = baseUrl
        if (authToken.startsWith("Basic") || authToken.startsWith("Bearer")) {
            this.authToken = authToken
        } else {
            this.authToken = "Basic $authToken";
        }
    }



    def upload(File localFile, String remoteFilePath) {
        def endpoint = "remote.php/dav/files"

        URL url = new URL("$baseUrl/$endpoint/$remoteFilePath");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("Authorization", authToken)
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        DataOutputStream request = new DataOutputStream(connection.getOutputStream());
        request.write(localFile.bytes)
        request.flush();
        int respCode = connection.getResponseCode();
        println("respCode = $respCode")
        def response = connection.getInputStream().getText()
        println("response = $response")

    }

    def delete(String remotePath) {
        def endpoint = "remote.php/dav/files"

        URL url = new URL("$baseUrl/$endpoint/$remotePath");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("Authorization", authToken)
        connection.setRequestMethod("DELETE");
        int respCode = connection.getResponseCode();
        println("respCode = $respCode")
        def response = connection.getInputStream().getText()
        println("response = $response")
    }

    def createShareLink(String remoteFilePath, String shareName, Integer shareType = 3, Integer permissions = 3) {
        def request = new URL("$baseUrl/ocs/v1.php/apps/files_sharing/api/v1/shares").openConnection();
        def requestBody = new CreateShareRequest(
                remoteFilePath,
                shareName,
                shareType,
                permissions
        ).toString()

        request.setRequestMethod("POST")
        request.setDoOutput(true)
        request.setRequestProperty("Content-Type", "application/json")
        request.setRequestProperty("Authorization", authToken)
        request.getOutputStream().write(requestBody.getBytes("UTF-8"))
        def postRC = request.getResponseCode();
        if (postRC == 200) {
            def response = request.getInputStream().getText()
            return  CreateShareResponseConverter.convertXmlToCreateShareResponse(response)
        } else {
            throw new Exception("Create share link request failed with code $postRC")
        }
    }

    def createDir(String remotePath) {
        def endpoint = "remote.php/dav/files"
        def parts = remotePath.split("/");
        if (parts.length > 0) {
            def path = ""
            for (def i = 0; i < parts.length; i++) {
                path += "${parts[i]}/"
                def cmd = "curl -X MKCOL \"$baseUrl/$endpoint/$path\" --header 'Authorization: $authToken'"
                def result = cmd.execute().getInputStream().getText()
                println("result: $result")
            }
        }

    }




}