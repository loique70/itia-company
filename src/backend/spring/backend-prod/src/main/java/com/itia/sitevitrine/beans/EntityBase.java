package com.itia.sitevitrine.beans;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.itia.sitevitrine.models.EntityBaseDTO;

import org.hibernate.annotations.Where;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

@MappedSuperclass
@Data
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "deleted = false")
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdOn;

    @Column(name = "last_update_on")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date lastUpdateOn;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(name = "deleted_at")
    @LastModifiedDate
    private LocalDateTime deletedAt;

    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private short status;

    public EntityBase() {
        super();
        this.createdOn = new Date();
    }

    public EntityBase(Long id) {
        this.id = id;
    }

    public EntityBase(Long id, Date createdOn) {
        this.id = id;
        this.createdOn = createdOn;
    };

    public EntityBase(EntityBaseDTO entityBaseDTO) {
        this.id = entityBaseDTO.getId();
        this.createdOn = entityBaseDTO.getCreatedOn();
        this.lastUpdateOn = entityBaseDTO.getLastUpdateOn();
        this.status = entityBaseDTO.getStatus();
    }

    public static EntityBaseDTO fromEntityBase(EntityBase entity) {
        return new EntityBaseDTO(entity);
    }

}