package uz.pdp.spring_boot_security_web.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.spring_boot_security_web.model.dto.SubjectRequestDTO;

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

    public SubjectEntity of(SubjectRequestDTO subjectRequestDTO){
        return SubjectEntity.builder()
                .title(subjectRequestDTO.getTitle())
                .build();
    }
}
