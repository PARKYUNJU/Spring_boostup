package com.sparta.springcore1.model;


import com.sparta.springcore1.domain.Timestamped;
import com.sparta.springcore1.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    //메모생성에 필요한 기능 :1.아이디 2.유저네임 3.콘텐츠(메모 내용) 4.비밀번호
    private Long id;
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;


    @Column(nullable = false)
    private String password;

    public Memo(String username, String contents, String title, String password) {
        this.username = username;
        this.contents = contents;
        this.title=title;
        this.password=password;
    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title=requestDto.getTitle();
        this.password= requestDto.getPassword();
    }

    public void update(MemoRequestDto requestDto)
    {
        this.contents=requestDto.getContents();
        this.title= requestDto.getTitle();
        this.password= requestDto.getPassword();
    }

    //비밀번호 비교해서 일치할때만 삭제하기
    //delete 할 때 필요한 정보만 클래스에 넣어놓기
    public void delete(MemoRequestDto requestDto)
    {
        this.password=requestDto.getPassword();
    }
}