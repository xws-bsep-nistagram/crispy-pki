package rs.ac.uns.ftn.bsep.pki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.bsep.pki.domain.certificate.Certificate;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    @Query(value = "select c from Certificate c where c.serialNumber = ?1")
    Certificate findBySerialNumber(String serialNumber);

    @Query(value = "select c from Certificate c where c.revoked = false")
    List<Certificate> getNonRevoked();

    @Query(value = "select c from Certificate c where c.revoked = false " +
            "and c.certificateType = rs.ac.uns.ftn.bsep.pki.domain.enums.CertificateType.SELF_SIGNED " +
            "or c.certificateType = rs.ac.uns.ftn.bsep.pki.domain.enums.CertificateType.INTERMEDIATE")
    List<Certificate> getNonRevokedCAs();

    List<Certificate> findByChainIdLike(String chainId);
}
