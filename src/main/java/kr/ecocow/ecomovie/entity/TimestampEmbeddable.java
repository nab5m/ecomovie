package kr.ecocow.ecomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TimestampEmbeddable {
    @Column(insertable = false, updatable = false)
    private LocalDateTime creationDateTime;

    @Column(insertable = false, updatable = false)
    private LocalDateTime lastUpdateDateTime;

    private LocalDateTime deletionDateTime;
}
