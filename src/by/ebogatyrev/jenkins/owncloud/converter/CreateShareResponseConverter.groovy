package by.ebogatyrev.jenkins.owncloud.converter

import by.ebogatyrev.jenkins.owncloud.model.share.CreateShareResponse

import groovy.xml.XmlSlurper

class CreateShareResponseConverter {

    static CreateShareResponse convertXmlToCreateShareResponse(String xmlResponse) {
        def ocs = new XmlSlurper().parseText(xmlResponse.trim())
        new CreateShareResponse(
                Integer.parseInt(ocs.data.id.text()),
                Integer.parseInt(ocs.data.share_type.text()),
                ocs.data.uid_owner.text(),
                ocs.data.displayname_owner.text(),
                Integer.parseInt(ocs.data.permissions.text()),
                Long.parseLong(ocs.data.stime.text()),
                ocs.data.expiration.text(),
                ocs.data.token.text(),
                ocs.data.uid_file_owner.text(),
                ocs.data.displayname_file_owner.text(),
                ocs.data.path.text(),
                ocs.data.item_type.text(),
                ocs.data.mimetype.text(),
                ocs.data.storage_id.text(),
                Integer.parseInt(ocs.data.storage.text()),
                Integer.parseInt(ocs.data.item_source.text()),
                Integer.parseInt(ocs.data.file_source.text()),
                Integer.parseInt(ocs.data.file_parent.text()),
                ocs.data.file_target.text(),
                ocs.data.share_with.text(),
                ocs.data.share_with_displayname.text(),
                ocs.data.url.text(),
                Integer.parseInt(ocs.data.mail_send.text()),
                ocs.data.name.text(),
        )
    }
}
