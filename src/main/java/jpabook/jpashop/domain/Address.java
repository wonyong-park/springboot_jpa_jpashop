package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable //내장 타입으로 사용할 수 있다는 어노태이션
@Getter @Setter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
