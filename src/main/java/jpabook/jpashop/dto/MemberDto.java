package jpabook.jpashop.dto;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    public MemberDto(Member member){
        id = member.getId();
        name = member.getName();
        city = member.getAddress().getCity();
        street = member.getAddress().getStreet();
        zipcode = member.getAddress().getZipcode();
    }
}
