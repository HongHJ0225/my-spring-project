package hello.core.order;

import hello.core.discount.DiscountPoilcy;
import hello.core.discount.FixDiscountPoilcy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPoilcy discountPoilcy;

    public OrderServiceImpl(MemoryMemberRepository memoryMemberRepository, DiscountPoilcy DiscountPoilcy) {
        this.memberRepository = memoryMemberRepository;
        this.discountPoilcy = DiscountPoilcy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPoilcy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
