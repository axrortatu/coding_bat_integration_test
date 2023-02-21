package uz.pdp.spring_boot_security_web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.spring_boot_security_web.config.AuditListener;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@EntityListeners(AuditListener.class)
public class TopicEntity extends BaseEntity {

   private String name;
   @ManyToOne
   private SubjectEntity subjectEntity;

}
