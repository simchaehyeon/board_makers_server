package BMproject.BMproject1.domain.posting.dto.response;

import BMproject.BMproject1.domain.posting.entity.Posting;
import lombok.Builder;

@Builder
public record PostingGetDetailResponse(
        String category,
        String title,
        String author,
        String content,
        boolean isLike,
        String createdAt
) {

    public static PostingGetDetailResponse from(Posting posting) {
        return PostingGetDetailResponse.builder()
                .category(posting.getCategory())
                .createdAt(posting.getCreatedAt().toString())
                .content(posting.getContent())
                .author(posting.getAuthor())
                .isLike(posting.isIslike())
                .title(posting.getTitle())
                .build();
    }
}
