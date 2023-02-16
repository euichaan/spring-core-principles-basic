package hello.core.member;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemberServiceTest {

	MemberService memberService = new MemberServiceImpl();

	@Test
	void 회원가입() {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);

		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);

		//then
		assertThat(member).isEqualTo(findMember);
	}
}
