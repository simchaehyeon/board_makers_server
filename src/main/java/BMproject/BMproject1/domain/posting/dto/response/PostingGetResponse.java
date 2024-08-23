package BMproject.BMproject1.domain.posting.dto.response;

import BMproject.BMproject1.domain.posting.entity.Posting;
import lombok.Builder;

@Builder
public record PostingGetResponse(
        String category,
        String title,
        String content
) {
    public static PostingGetResponse from(Posting posting){
        return PostingGetResponse.builder()
                .category(posting.getCategory())
                .title(posting.getTitle())
                .content(posting.getContent())
                .build();
    }
}
