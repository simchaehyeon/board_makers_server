package BMproject.BMproject1.domain.posting.dto.request;

import java.time.LocalDate;

public record PostingCreateRequest(
        String category,
        String title,
        String author,
        String content
) {
}
