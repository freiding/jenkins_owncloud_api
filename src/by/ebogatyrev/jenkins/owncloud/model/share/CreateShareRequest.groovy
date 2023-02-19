package by.ebogatyrev.jenkins.owncloud.model.share

class CreateShareRequest {
    final String path
    final String name
    final Integer shareType
    final Integer permissions

    CreateShareRequest(String path, String name, Integer shareType, Integer permissions) {
        this.path = path
        this.name = name
        this.shareType = shareType
        this.permissions = permissions
    }

    @Override
    String toString() {
        return "{ \"path\": \"${this.path}\", \"name\": \"${this.name}\", \"shareType\": ${shareType}, \"permissions\": $permissions }"
    }

    @Override
    int hashCode() {
        int result
        result = (path != null ? path.hashCode() : 0)
        result = 31 * result + (name != null ? name.hashCode() : 0)
        result = 31 * result + (shareType != null ? shareType : 0)
        result = 31 * result + (permissions != null ? permissions : 0)
        return result
    }
}
