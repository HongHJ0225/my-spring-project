package hello.core;

import hello.core.discount.DiscountPoilcy;
import hello.core.discount.FixDiscountPoilcy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //역할
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    //역할에 대한 구현
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //역할
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    //역할에 대한 구현
    @Bean
    private static DiscountPoilcy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
