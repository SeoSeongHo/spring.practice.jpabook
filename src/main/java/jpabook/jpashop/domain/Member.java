package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // order table 에 있는 member 에 의해 맵핑되었다는 것을 의미, 값을 넣는다고 해서 foreign key 값이 변경 x
    private List<Order> orders = new ArrayList<>();
}
