package hello.core;

import hello.core.discount.DiscountPoilcy;
import hello.core.discount.FixDiscountPoilcy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //역할
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    //역할에 대한 구현
    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //역할
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    //역할에 대한 구현
    private static DiscountPoilcy discountPolicy() {
        return new FixDiscountPoilcy();
    }
}
