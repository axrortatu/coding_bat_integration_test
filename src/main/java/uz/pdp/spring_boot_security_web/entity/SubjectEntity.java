package uz.pdp.spring_boot_security_web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class SubjectEntity extends BaseEntity{

    private String title;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "subjectEntity")
    private List<TopicEntity> topicEntities;

}
