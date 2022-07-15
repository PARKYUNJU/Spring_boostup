package com.sparta.springcore1.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter//필수
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식합니다.
//MappedSuperclass: 작성시간이나 수정시간으로 자동으로 column으로 인식
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
public abstract class Timestamped {

    @CreatedDate //생성시간
    private LocalDateTime createdAt;

    @LastModifiedDate //수정시간
    private LocalDateTime modifiedAt;



}