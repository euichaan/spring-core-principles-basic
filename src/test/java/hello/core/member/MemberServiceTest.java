package hello.core.member;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

class MemberServiceTest {

	MemberService memberService;

	@BeforeEach
	void initialize() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}

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
