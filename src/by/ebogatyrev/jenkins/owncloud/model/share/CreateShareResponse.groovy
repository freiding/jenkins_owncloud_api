package by.ebogatyrev.jenkins.owncloud.model.share

class CreateShareResponse {
    final Integer id;
    final Integer shareType;
    final String uidOwner;
    final String displayNameOwner;
    final Integer permissions;
    final Long stime;
    final String token;
    final String expiration;
    final String uidFileOwner
    final String displayNameFileOwner;
    final String path;
    final String itemType
    final String mimeType;
    final String storageId;
    final Integer storage;
    final Integer itemSource;
    final Integer fileSource;
    final Integer fileParent;
    final String fileTarget;
    final String shareWith;
    final String shareWithDisplayName
    final String url;
    final Integer mailSend;
    final String name;

    /**
     *
     * @param id The share’s unique id.
     * @param shareType The share’s type.
     * @param uidOwner The username of the owner of the share.
     * @param displayNameOwner The display name of the owner of the share.
     * @param permissions The permission attribute set on the file. Options are:
     * 1 = Read * 2 = Update * 4 = Create * 8 = Delete * 16 = Share * 31 = All permissions
     * The default is 31, and for public link shares is 1.
     * @param stime The UNIX timestamp when the share was created.
     * @param token The public link to the item being shared.
     * @param expiration The date when the share expires, in format YYYY-MM-DD 00:00:00.
     * @param uidFileOwner The unique id of the user that owns the file or folder being shared.
     * @param displayNameFileOwner The display name of the user that owns the file or folder being shared.
     * @param path The path to the shared file or folder.
     * @param itemType The type of the object being shared. This can be one of file or folder.
     * @param mimeType The RFC-compliant mimetype of the file.
     * @param storageId
     * @param storage
     * @param itemSource The unique node id of the item being shared.
     * @param fileSource The unique node id of the item being shared. For legacy reasons item_source and file_source attributes have the same value.
     * @param fileParent The unique node id of the parent node of the item being shared.
     * @param fileTarget The name of the shared file.
     * @param shareWith The uid of the receiver of the file. This is either a GID (group id) if it is being shared with a group or a UID (user id) if the share is shared with a user.
     * @param shareWithDisplayName The display name of the receiver of the file.
     * @param url
     * @param mailSend Whether the recipient was notified, by mail, about the share being shared with them.
     * @param name A (human-readable) name for the share, which can be up to 64 characters in length
     *
     * @see <a href="https://doc.owncloud.com/server/next/developer_manual/core/apis/ocs-share-api.html#create-a-new-share">OwnCloud Create a New Share doc</a>
     */
    CreateShareResponse(
            Integer id,
            Integer shareType,
            String uidOwner,
            String displayNameOwner,
            Integer permissions,
            Long stime,
            String token,
            String expiration,
            String uidFileOwner,
            String displayNameFileOwner,
            String path,
            String itemType,
            String mimeType,
            String storageId,
            Integer storage,
            Integer itemSource,
            Integer fileSource,
            Integer fileParent,
            String fileTarget,
            String shareWith,
            String shareWithDisplayName,
            String url,
            Integer mailSend,
            String name
    ) {
        this.id = id
        this.shareType = shareType
        this.uidOwner = uidOwner
        this.displayNameOwner = displayNameOwner
        this.permissions = permissions
        this.stime = stime
        this.token = token
        this.expiration = expiration
        this.uidFileOwner = uidFileOwner
        this.displayNameFileOwner = displayNameFileOwner
        this.path = path
        this.itemType = itemType
        this.mimeType = mimeType
        this.storageId = storageId
        this.storage = storage
        this.itemSource = itemSource
        this.fileSource = fileSource
        this.fileParent = fileParent
        this.fileTarget = fileTarget
        this.shareWith = shareWith
        this.shareWithDisplayName = shareWithDisplayName
        this.url = url
        this.mailSend = mailSend
        this.name = name
    }
}
