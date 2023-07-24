package tech.rowi.dbo.claimapi.dto.audit;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableStatusHistory {

    @CreatedDate
    @Column(name = "updated_date", updatable = false)
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(name = "updated_by", updatable = false)
    private String createdBy;

}
