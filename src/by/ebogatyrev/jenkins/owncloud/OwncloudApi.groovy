package by.ebogatyrev.jenkins.owncloud

import by.ebogatyrev.jenkins.owncloud.converter.CreateShareResponseConverter
import by.ebogatyrev.jenkins.owncloud.model.share.CreateShareRequest

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



    def upload(File localFilePath, String remoteFilePath) {
        def endpoint = "remote.php/dav/files"
        def cmd = "curl -X PUT '$baseUrl/$endpoint/$remoteFilePath'" +
                " --header 'Authorization: $authToken'" +
                " --data-binary '@$localFilePath'"
        cmd.execute()
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

}