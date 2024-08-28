package BMproject.BMproject1.domain.posting.dto.request;

public record PostingUpdateRequest(
        String category,
        String title,
        String content
) {
}
