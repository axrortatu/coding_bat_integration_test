package uz.pdp.spring_boot_security_web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_security_web.common.exception.RecordAlreadyExist;
import uz.pdp.spring_boot_security_web.common.exception.RecordNotFountException;
import uz.pdp.spring_boot_security_web.entity.SubjectEntity;
import uz.pdp.spring_boot_security_web.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {

    //TODO for @Asror validation for title : Java, JavaScript are correct but JaVa is incorrect
    private final SubjectRepository subjectRepository;

    public List<SubjectEntity> getSubjectList() {
        return subjectRepository.findAll();
    }


    public SubjectEntity getByTitle(String title) {
        return subjectRepository.findByTitleIgnoreCase(title).orElseThrow(() -> new RecordNotFountException(String.format("subject %s not found", title)));
    }

    private void checkByTitle(String title) {
        Optional<SubjectEntity> optionalSubjectEntity = subjectRepository.findByTitleIgnoreCase(title);
        if (optionalSubjectEntity.isPresent()) {
            throw new RecordAlreadyExist(String.format("subject %s already exists", title));
        }
    }

    public void addSubject(String title) {
        checkByTitle(title);
        SubjectEntity subjectEntity = SubjectEntity.builder().title(title).build();
        subjectRepository.save(subjectEntity);
    }

    public SubjectEntity editSubject(String oldTitle, String newTitle) {
        checkByTitle(newTitle);
        SubjectEntity subject = getByTitle(oldTitle);
        subject.setTitle(newTitle);
        return subjectRepository.save(subject);
    }

    public void deleteSubject(String title) {
        SubjectEntity subjectEntity = getByTitle(title);
        subjectRepository.deleteById(subjectEntity.getId());
    }


}
