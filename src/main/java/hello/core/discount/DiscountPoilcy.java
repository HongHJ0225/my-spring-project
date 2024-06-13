package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPoilcy {

    int discount(Member member, int price);
}
