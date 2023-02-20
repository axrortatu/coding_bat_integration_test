package uz.pdp.spring_boot_security_web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_security_web.entity.SubjectEntity;
import uz.pdp.spring_boot_security_web.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<SubjectEntity> subjectEntityList() {
        return subjectRepository.findAll();
    }
    public SubjectEntity getSubject(String name){
        Optional<SubjectEntity> optionalSubjectEntity = subjectRepository.findByTitle(name);
        return optionalSubjectEntity.orElse(null);
    }

//    public List<SubjectEntity> topicEntities(String title) throws RecordNotFountException {
//        Optional<SubjectEntity> byTitle = subjectRepository.findByTitle(title);
//        return byTitle.orElseThrow( ()->new RecordNotFountException(title + " not found "));
//
//    }

//    public boolean add(SubjectRequestDTO subjectDTO){
//        SubjectEntity subjectEntity = new SubjectEntity(subjectDTO);
//        subjectRepository.save(subjectEntity);
//    }



}
