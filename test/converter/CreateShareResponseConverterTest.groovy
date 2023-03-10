package by.ebogatyrev.jenkins.owncloud

import by.ebogatyrev.jenkins.owncloud.model.share.CreateShareResponse
import by.ebogatyrev.jenkins.owncloud.converter.CreateShareResponseConverter
import org.junit.Test;
import static groovy.test.GroovyAssert.*


class CreateShareResponseConverterTest {

    @Test
    void testParseSuccessfulResponse() {
        def urlExpected = "https://your.owncloud.install.com/owncloud/index.php/s/11CUiVe0l7iaIwM"
        def xmlString = '''
        <?xml version="1.0"?>
        <ocs>
          <meta>
            <status>ok</status>
            <statuscode>100</statuscode>
            <message/>
          </meta>
          <data>
            <id>115470</id>
            <share_type>3</share_type>
            <uid_owner>auser</uid_owner>
            <displayname_owner>A User</displayname_owner>
            <permissions>1</permissions>
            <stime>1481552410</stime>
            <parent/>
            <expiration>2017-01-01 00:00:00</expiration>
            <token>11CUiVe0l7iaIwM</token>
            <uid_file_owner>auser</uid_file_owner>
            <displayname_file_owner>A User</displayname_file_owner>
            <path>/Photos/Paris.jpg</path>
            <item_type>file</item_type>
            <mimetype>image/jpeg</mimetype>
            <storage_id>home::auser</storage_id>
            <storage>993</storage>
            <item_source>3994486</item_source>
            <file_source>3994486</file_source>
            <file_parent>3994485</file_parent>
            <file_target>/Shared/Paris.jpg</file_target>
            <share_with/>
            <share_with_displayname/>
            <url>https://your.owncloud.install.com/owncloud/index.php/s/11CUiVe0l7iaIwM</url>
            <mail_send>0</mail_send>
            <name>paris photo</name>
          </data>
        </ocs>
        '''

        CreateShareResponse response = CreateShareResponseConverter.convertXmlToCreateShareResponse(xmlString)

        assertEquals(response.url, urlExpected)
    }
}