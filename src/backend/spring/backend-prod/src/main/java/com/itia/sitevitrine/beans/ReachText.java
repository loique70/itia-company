package com.itia.sitevitrine.beans;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ReachText extends EntityBase {

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", nullable = true)
    protected String content;
}