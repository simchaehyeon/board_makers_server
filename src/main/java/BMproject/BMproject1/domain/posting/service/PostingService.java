package BMproject.BMproject1.domain.posting.service;

import BMproject.BMproject1.domain.posting.dto.request.PostingCreateRequest;
import BMproject.BMproject1.domain.posting.dto.request.PostingUpdateRequest;
import BMproject.BMproject1.domain.posting.dto.response.PostingGetDetailResponse;
import BMproject.BMproject1.domain.posting.dto.response.PostingGetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostingService {
    PostingGetDetailResponse getPostings(long postingId);

    long createPosting(PostingCreateRequest request);

    void deletePosting(long id);

    long updatePosting(long postingId, PostingUpdateRequest request);

    List<PostingGetResponse> getPostingList(String author);

    long updateLike(long postingId);

    long getPostingNum();
}
