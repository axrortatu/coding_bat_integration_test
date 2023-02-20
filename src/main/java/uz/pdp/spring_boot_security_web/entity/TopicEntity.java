package uz.pdp.spring_boot_security_web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class TopicEntity extends BaseEntity {

   private String name;
   @ManyToOne
   private SubjectEntity subjectEntity;

}
