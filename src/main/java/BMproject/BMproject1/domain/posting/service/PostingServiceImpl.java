package BMproject.BMproject1.domain.posting.service;

import BMproject.BMproject1.domain.posting.dto.request.PostingCreateRequest;
import BMproject.BMproject1.domain.posting.dto.request.PostingUpdateRequest;
import BMproject.BMproject1.domain.posting.dto.response.PostingGetDetailResponse;
import BMproject.BMproject1.domain.posting.dto.response.PostingGetResponse;
import BMproject.BMproject1.domain.posting.entity.Posting;
import BMproject.BMproject1.domain.posting.repository.PostingRepository;
import BMproject.BMproject1.global.error.exception.ErrorCode;
import BMproject.BMproject1.global.error.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostingServiceImpl implements PostingService {
    private final PostingRepository postingRepository;

    @Override
    public PostingGetDetailResponse getPostings(long postingId) {
        Posting posting = postingRepository.findById(postingId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.POST_NOT_FOUND));
        //TODO orElseThrow는 get()의 역할까지 해준다. 존재하면 지가 알아서 걍 넣어줌.
        // 그래서 아래의 get 코드를 삭제해도 됨.
        // Posting posting =  postOptional.get();

        return PostingGetDetailResponse.from(posting);
    }

    @Override
    @Transactional
    public long createPosting(PostingCreateRequest request) {
        Posting posting = Posting.builder()
                .author(request.author())
                .title(request.title())
                .content(request.content())
                .category(request.category())
                .build();

        return postingRepository.save(posting).getId();
    }

    @Override
    public void deletePosting(long id) {
        postingRepository.deleteById(id); //TODO 삭제는 save를 안 해도 되는 거야? => 레포에서 db로 요청 쏴서 알아서 업데이트됨.
        return;
    }

    @Override
    public long updatePosting(long postingId, PostingUpdateRequest request) {
        Posting posting = postingRepository.findById(postingId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.POST_NOT_FOUND));
        posting.setCategory(request.category());
        posting.setTitle(request.title());
        posting.setContent(request.content());

        return postingRepository.save(posting).getId();
    }

    @Override
    public List<PostingGetResponse> getPostingList(String author) {

        return postingRepository.findAllByAuthor(author).stream()
                .map(PostingGetResponse::from)
                .toList();

        //TODO posting -> PostingGetResponse.from(posting) 이거랑 PostingGetResponse::from 같은 거임

//        List<PostingGetResponse> postingGetResponseList = new ArrayList<>();
//
//        for(Posting posting : allByAuthor){
//            postingGetResponseList.add(PostingGetResponse.from(posting));
//        }
    }

    @Override
    public long updateLike(long postingId) {
        Posting posting = postingRepository.findById(postingId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.POST_NOT_FOUND));
        posting.setIslike(true); //TODO 가정문 추가해서 true이면 false로 바꿔주기
        return postingRepository.save(posting).getId();
    }

    @Override
    public long getPostingNum() {
        return postingRepository.count();
    }
}
