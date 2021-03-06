package rs.ac.uns.ftn.bsep.pki.domain.dto.extensions;

import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import rs.ac.uns.ftn.bsep.pki.domain.enums.ExtendedKeyPurpose;
import java.io.IOException;
import java.util.List;

public class ExtendedKeyPurposesDTO {

    private boolean critical;
    private List<ExtendedKeyPurpose> extendedKeyPurposes;

    public ExtendedKeyPurposesDTO() {
    }

    public boolean getCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    public List<ExtendedKeyPurpose> getExtendedKeyPurposes() {
        return extendedKeyPurposes;
    }

    public void setExtendedKeyPurposes(List<ExtendedKeyPurpose> extendedKeyPurposes) {
        this.extendedKeyPurposes = extendedKeyPurposes;
    }
    public Extension toExtension() throws IOException {

        if(extendedKeyPurposes.size() == 0)
            return null;

        var keyPurposeIds = new KeyPurposeId[extendedKeyPurposes.size()];

        for (int i = 0 ; i < extendedKeyPurposes.size() ; i++)
            keyPurposeIds[i] = extendedKeyPurposes.get(i).getKeyPurposeId();

        return new Extension(
                Extension.extendedKeyUsage,
                critical,
                new DEROctetString(new ExtendedKeyUsage(keyPurposeIds)));
    }
}
