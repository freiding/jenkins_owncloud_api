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
    void createSharePublicLinkTest() {
        def result = api.createShareLink("/docker-compose.yml", "shareName")
        assertEquals(result.name, "shareName")
        assert result.url != null && result.url.length() > 0
    }
}
