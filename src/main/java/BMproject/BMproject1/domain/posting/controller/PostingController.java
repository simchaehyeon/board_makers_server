package BMproject.BMproject1.domain.posting.controller;

import BMproject.BMproject1.domain.posting.dto.request.PostingCreateRequest;
import BMproject.BMproject1.domain.posting.dto.request.PostingUpdateRequest;
import BMproject.BMproject1.domain.posting.dto.response.PostingGetDetailResponse;
import BMproject.BMproject1.domain.posting.dto.response.PostingGetResponse;
import BMproject.BMproject1.domain.posting.entity.Posting;
import BMproject.BMproject1.domain.posting.service.PostingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostingController {
    private final PostingService postingService;

    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @GetMapping("/postings/num")
    public ResponseEntity<Long> getPostingNum(){
        return ResponseEntity.ok(postingService.getPostingNum());
    }

    @GetMapping("/postings/{posting-author}") //TODO 이거 맞나?
    public ResponseEntity<List<PostingGetResponse>> getPostingList(
            @PathVariable("posting-author") String author
    ){
        return ResponseEntity.ok(postingService.getPostingList(author));
    }

    @GetMapping("/postings/{posting-id}")
    public ResponseEntity<PostingGetDetailResponse> getPostings(
            @PathVariable("posting-id") Long postingId
    ){
        return ResponseEntity.ok(postingService.getPostings(postingId));
    }

    @PutMapping("/postings/{posting-id}")
    public ResponseEntity<Long> updateLike(
            @PathVariable("posting-id") Long postingId
    ){
        return ResponseEntity.ok(postingService.updateLike(postingId));
    }

    @PostMapping("/postings")
    public ResponseEntity<Long> createPosting(
            @RequestBody PostingCreateRequest request
    ){
        return ResponseEntity.ok(postingService.createPosting(request));
    }

    @PutMapping("/postings/{posting-id}")
    public ResponseEntity<Long> updatePosting(
            @PathVariable("posting-id") Long postingId,
            @RequestBody PostingUpdateRequest request
    ){
        return ResponseEntity.ok(postingService.updatePosting(postingId, request));
    }

    @DeleteMapping("/postings/{posting-id}")
    public ResponseEntity<Long> deletePosting(
            @PathVariable("posting-id") Long postingId
    ){
        postingService.deletePosting(postingId);
        return ResponseEntity.ok(postingId); //TODO 이게 맞누...?
    }
}
