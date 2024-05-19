package com.itia.sitevitrine.models;

import java.util.Date;

import com.itia.sitevitrine.beans.ReachText;

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
public class ReachTextDTO extends EntityBaseDTO {
    protected String content;

    public ReachTextDTO(ReachText reachText) {
        this.content = reachText.getContent();
    }

    public ReachTextDTO(Long id) {
        super(id);
    }
}