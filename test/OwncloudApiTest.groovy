import by.ebogatyrev.jenkins.owncloud.OwncloudApi
import org.junit.Before
import org.junit.Test
import static groovy.test.GroovyAssert.*

class OwncloudApiTest {
    OwncloudApi api

    @Before
    void setUp() {
        api = new OwncloudApi(TestConfig.OWNCLOUD_HOST, TestConfig.OWNCLOUD_AUTH_TOKEN)
    }

    @Test
    void uploadFileTest() {
        def file = new File("test/samples/file.txt");
        api.upload(file, "freiding/tmp/file.txt")
    }

    @Test
    void uploadFileByPathTest() {
        api.upload("test/samples/file.txt", "freiding/tmp/file.txt")
    }

    @Test
    void createSharePublicLinkTest() {
        def remotePath = "freiding/tmp/file.txt"
        def shareName = "File to Share"
        def result = api.createShareLink(remotePath, shareName)
        assertEquals(result.name, shareName)
        assert result.url != null && result.url.length() > 0
    }

    @Test
    void deleteFileTest() {
        api.delete("freiding/tmp/file.txt")
    }

    @Test
    void createDirTest() {
        api.createDir("freiding/temp/builds/48")
    }
}
