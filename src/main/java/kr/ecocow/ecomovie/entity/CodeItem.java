package kr.ecocow.ecomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CodeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(value = 0)
    private Long codeItemId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "code_category_id")
    private CodeCategory codeCategory;

    @NotBlank
    @Size(max = 30)
    private String codeItemName;

    private int code;

    @Embedded
    private TimestampEmbeddable timestampEmbeddable;
}
