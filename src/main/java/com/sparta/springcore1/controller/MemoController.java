package com.sparta.springcore1.controller;



import com.sparta.springcore1.model.Memo;
import com.sparta.springcore1.repository.MemoRepository;
import com.sparta.springcore1.dto.MemoRequestDto;
import com.sparta.springcore1.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor //final 할 때 필수
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    //메모 생성 (POST)
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto)//필수:@RequestBody
    {
        //메모 생성
        Memo memo = new Memo(requestDto);
        //그대로 저장
        System.out.println(requestDto.getPassword()); //비번은 dto로 잘 넘어감
        return memoRepository.save(memo);
    }
    //생성 문제 없음

    //메모 조회
    @GetMapping("/api/memos")
    public List<Memo> readMemo() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/memos/{id}")
    public Memo detailMessage(@PathVariable long id) {
        return memoRepository.findById(id).orElse(null);
    }

    //메모 수정
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Memo memo=memoRepository.findById(id).orElseThrow(()->new NullPointerException("id가 존재하지 않습니다"));
        long error=404;
        if(memo.getPassword().equals(requestDto.getPassword())){
            return memoService.update(id,requestDto);
        };
        return error;
    }

    //메모 삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto) {
        Memo memo=memoRepository.findById(id).orElseThrow(()->new NullPointerException("id가 존재하지 않습니다"));
        long error=404;
        if(memo.getPassword().equals(requestDto.getPassword())){
            memoRepository.deleteById(id);
            return id;
        }
        return error;

    }
}