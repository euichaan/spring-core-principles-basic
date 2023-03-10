# 스프링 핵심 원리 - 기본편
EJB : Enterprise Java Beans 예전 자바 표준  
복잡하고 어려운데, 느린 단점.

하이버네이트 : EJB 엔티티빈 기술을 대체. JPA(Java Persistence API) 새로운 표준 정의

표준 인터페이스 JPA를 구현한 하이버네이트, EclipseLink, 기타 등등..

2014년 스프링 부트 1.0 출시

## 스프링 프레임워크 : 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임워크
핵심 기술 : 스프링 DI 컨테이너, AOP, 이벤트, 기타  
웹 기술 : 스프링 MVC, 스프링 WebFlux  
데이터 접근 기술 : 트랜잭션, JDBC, ORM 지원, XML 지원  
기술 통합 : 캐시, 이메일, 원격 접근, 스케줄링  
테스트 : 스프링 기반 테스트 지원  
언어: 코틀린, 그루비
- 최근에는 스프링 부트를 통해서 스프링 프레임워크의 기술들을 편리하게 사용

## 스프링 부트
스프링을 편리하게 사용할 수 있도록 지원.  
단독으로 실행할 수 있는 스프링 애플리케이션을 쉽게 생성  
Tomcat 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 됨  
손쉬운 빌드 구성을 위한 starter 종속성 제공  
스프링과 3rd party(외부) 라이브러리 자동 구성  
메트릭, 상태 확인, 외부 구성 같은 프로덕션 준비 기능 제공  
관례에 의한 간결한 설정

## 스프링 단어?
스프링이라는 단어는 문맥에 따라 다르게 사용된다.
- 스프링 DI 컨테이너 기술(Bean 관리 등)
- 스프링 프레임워크
- 스프링 부트, 스프링 프레임워크 등을 모두 포함한 스프링 생태계

## 스프링의 진짜 핵심
- 스프링은 자바 언어 기반의 프레임워크
- 자바 언어의 가장 큰 특징 - 객체 지향 언어
- 스프링은 **객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크**
- 스프링은 **좋은 객체 지향 애플리케이션을 개발할 수 있게 도와주는 프레임워크**

기존 EJB는 객체 지향의 장점들을 잃어버림.  
스프링은 제대로 된 객체지향 프로그램을 할 수 있도록 도와주는 도구.

## 좋은 객체 지향 프로그래밍?
- 객체 지향 프로그래밍은 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어나 여러개의 독립된 단위,  
  즉 "객체"들의 모임으로 파악하고자 하는 것이다. 각각의 객체는 메시지를 주고받고, 데이터를 처리할 수 있다(협력)
- 객체 지향 프로그래밍은 프로그램을 유연하고 변경에 용이하게 만들기 때문에 대규모 소프트웨어 개발에 많이 사용된다.

유연하고 변경이 용이? - 다형성(Polymorphism)  
다형성을 실세계 비유하면 이해하기에는 좋다.

## 역할(인터페이스)과 구현(구현체)으로 세상을 구분
운전자 - 자동차  
운전자는 자동차의 인터페이스(역할)에 대해서만 의존을 하고있다.  
운전자(Clinet)는 자동차의 내부 구조를 몰라도 된다.  
클라이언트에 영향을 주지 않고 새로운 기능을 제공할 수 있다.

로미오와 줄리엣 공연  
역할 - 로미오 역할, 줄리엣 역할  
구현 - 장동건, 원빈, 김태희, 송혜교  
배우는 대체가 가능해야 한다. 유연하고 변경에 용이하다.

## 역할과 구현을 분리
역할과 구현으로 구분하면 세상이 단순해지고, 유연해지며 변경도 편리해진다.
- 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
- 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
- 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
- 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.

## 역할과 구현을 분리 - 자바 언어
자바 언어의 다형성을 활용
- 역할 = 인터페이스
- 구현 = 인터페이스를 구현한 클래스, 구현 객체  
  객체를 설계할 때 역할과 구현을 명확히 분리  
  객체 설계 시 역할(인터페이스)을 먼저 부여하고, 그 역할을 수행하는 구현 객체 만들기.

## 객체의 협력이라는 관계부터 생각
혼자 있는 객체는 없다.  
클라이언트 : 요청, 서버 : 응답  
수 많은 객체 클라이언트와 객체 서버는 서로 협력 관계를 가진다.

## 자바 언어의 다형성
오버라이딩 된 메서드가 실행  
다형성으로 인터페이스를 구현한 객체를 실행 시점에 유연하게 변경할 수 있다.  
의존한다 == 알고 있다

인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경할 수 있다.  
다형성의 본질을 이해하려면 협력이라는 객체사이의 관계에서 시작해야함  
클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.

## 역할과 구현의 분리 - 한계
인터페이스 자체가 변하면, 클라이언트, 서버 모두에 큰 변경이 발생한다.  
인터페이스를 안정적으로 잘 설계하는 것이 중요.

# 스프링과 객체 지향
다형성이 가장 중요하다!  
스프링은 다형성을 극대화해서 이용할 수 있게 도와준다.  
스프링에서 이야기하는 제어의 역전(IoC), 의존관계 주입(DI)은 다형성을 활용해서 역할과 구현을 편리하게 다룰  
수 있도록 지원한다.

다형성 + SOLID  
다형성 만으로는 구현 객체를 변경할 때 클라이언트 코드도 함께 변경된다.  
다형성 만으로는 OCP, DIP를 지킬 수 없다.  
뭔가 더 필요하다.

# 객체 지향 설계와 스프링
스프링은 다음 기술로 다형성 + OCP, DIP 를 가능하게 지원한다.
- DI(Dependency Injection) : 의존관계, 의존성 주입
- DI 컨테이너 제공. (Java 객체들을 컨테이너 안에 넣어두고 이 안에서 의존관계 연결, 주입)  
  클라이언트 코드의 변경 없이 기능 확장  
  쉽게 부품을 교체하듯이 개발

순수하게 OCP, DIP 원칙을 지키면서 개발을 해보면, 결국 스프링 프레임워크를 만들게 된다.(DI 컨테이너)

애플리케이션 설계도 공연을 설계 하듯이 배역(역할)만 만들어두고, 배우(구현)은 언제든지 유연하게 변경  
할 수 있도록 만드는 것이 좋은 객체 지향 설계다.  
이상적으로는 모든 설계에 인터페이스를 부여하자.

하지만 인터페이스를 도입하면 추상화라는 비용이 발생한다.  
기능을 확장할 가능성이 없다면, 구체 클래스를 직접 사용하고, 향후 꼭 필요할 때 리팩터링해서  
인터페이스를 도입하는 것도 방법이다.  
 