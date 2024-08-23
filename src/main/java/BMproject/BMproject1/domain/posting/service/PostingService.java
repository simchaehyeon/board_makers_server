package BMproject.BMproject1.domain.posting.service;

import BMproject.BMproject1.domain.posting.dto.request.PostingCreateRequest;
import BMproject.BMproject1.domain.posting.dto.response.PostingGetDetailResponse;
import BMproject.BMproject1.domain.posting.dto.response.PostingGetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostingService {
    PostingGetDetailResponse getPostings(Long postingId);

    long createPosting(PostingCreateRequest request);

    void deletePosting();

    void updatePosting();

    List<PostingGetResponse> getPostingList(String author);

    void updateLike();

    void getPostingNum();
}
