package BMproject.BMproject1.domain.posting.entity;

import BMproject.BMproject1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Posting extends BaseEntity {
    @Id
    private long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String category;

    private String title;

    private String author;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private String content;

    private boolean islike;

    @Builder
    public Posting(String category, String title, String author, String content, boolean islike){
        this.category = category;
        this.title = title;
        this.author = author;
        this.content = content;
        this.islike = islike;
    }
}
