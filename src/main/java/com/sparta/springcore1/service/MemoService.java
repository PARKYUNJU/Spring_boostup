package com.sparta.springcore1.service;

import com.sparta.springcore1.dto.MemoRequestDto;
import com.sparta.springcore1.model.Memo;
import com.sparta.springcore1.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//service는 수정을 위한 것임
@RequiredArgsConstructor //필수
@Service
public class MemoService {

    private final MemoRepository memoRepository;//필수:final 필수

    @Transactional //필수:db에 진짜 반영하셈
    public Long update(Long id,MemoRequestDto requestDto) {
        Memo memo= memoRepository.findById(id).orElseThrow(() -> new NullPointerException("ID값이나 비밀번호가 틀립니다."));
        //예외처리시 에러 발생 : MemoRepository에서 findByIdAndPassword는 Optional로 지정해줄 것
        memo.update(requestDto); //관련 데이터 다 들고있는 놈:Dto
        //update는 memo에 있어야하기 때문에 Memo 클래스에서 만들어놓기
        return memo.getId();//업데이트 된 메모의 아이디를 return
    }
}


