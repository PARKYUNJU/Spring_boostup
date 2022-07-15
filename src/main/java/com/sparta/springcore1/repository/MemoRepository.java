package com.sparta.springcore1.repository;

import com.sparta.springcore1.model.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();

    Optional<Memo> findByIdAndPassword(Long id,String password);
    //전부 찾아줘, 정렬해서, 수정된 날짜 기준으로, 최신순으로(내림차순)
    //공식문서 참고
    //ModifiedAt은 timestamped 안에 있음



}