package uz.pdp.spring_boot_security_web.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import uz.pdp.spring_boot_security_web.config.AuditListener;


import java.sql.Timestamp;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @CreatedBy
    protected String createdBy;

    @LastModifiedBy
    protected String updatedBy;

    @CreatedDate
    protected Timestamp createdDate;

    @LastModifiedDate
    protected Timestamp updatedDate;


}
