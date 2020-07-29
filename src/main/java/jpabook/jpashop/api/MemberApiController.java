package jpabook.jpashop.api;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.dto.MemberDto;
import jpabook.jpashop.dto.ResponseDto;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/api/v2/members")
    public ResponseDto<List<MemberDto>> getMembersV2(){
        List<MemberDto> result = memberService.findMembers()
                .stream()
                .map(m -> new MemberDto(m))
                .collect(Collectors.toList());
        return new ResponseDto<>(result);
    }

}
