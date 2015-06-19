[step01] - 기본 프로젝트를 Gradle 빌드 프로젝트로 포팅.

[step02] - Servlet + JSP + DAO + mybatis
* Mybatis
- persistence(지속성) framework
- JDBC 기능을 대행한다. 

[step03] - Servlet(x) Page Controller(Plain Old Java Object) 
           + JSP + DAO + mybatis + Front Controller(서블릿)
* Front Controller
- 클라이언트의 모든 요청을 받아서 적절한 컨트롤러에게 위임한다.
- 페이지 컨트롤러의 공통 기능을 수행
  1) 예외가 발생했을 때 특정 서블릿으로 포워딩(인클루딩) 시키는 것.
  2) JSP(view 컴포넌트)를 인클루드 하는 것.
  
* Page Controller
- 특정 페이지를 위한 작업을 수행.
- 해당 페이지에서 출력할 데이터를 준비.
- 해당 페이지를 위한 요청 데이터를 처리.

[step04] - Page Controller(POJO; controller 컴포넌트) 
           + JSP(view 컴포넌트)
           + DAO(model 컴포넌트) 
           + mybatis
           + Front Controller(서블릿)
           + Bean Container(= Object Manager) => Spring Bean Container

[step05] - Page Controller(POJO; controller 컴포넌트) 
           + JSP(view 컴포넌트)
           + DAO(model 컴포넌트) 
           + mybatis
           + Front Controller(서블릿)
           + Bean Container(= Object Manager) => Spring Bean Container 
           + Spring MVC 
           
[step06] - 페이지 컨트롤러
- 리턴 가능한 타입
- 파라미터 타입

[step07] - CRUD(Create, Read, Update, Delete)을 한 클래스로 묶는다. 

[step08] - Mybatis의 DAO 자동 생성기 투입

[step09] - View Resolver 변경하기
* view resolver (뷰 해결사)
- 페이지 컨트롤러가 리턴한 값에 대해 뷰 컴포넌트를 실행하는 일.

* 기존의 JSP를 WEB-INF/views/ 폴더로 옮긴다.

[step10] - Service 객체 도입
* Service 객체
- 업무 관련 로직을 실행
- 트랜잭션 처리
1) BOARD_LOG 테이블 생성한다.
2) BoardLog VO 클래스 만든다.

[step11] - Transaction 처리하는 방법
1) 코드에서 트랜잭션을 직접 관리하기
=> BoardService 클래스에 코드 추가

[step12] - Transaction 처리하는 방법
2) 애노테이션을 이용하여 트랜잭션 선언하기
=> BoardService 클래스에 @Transactional 애노테이션 추가
=> /WEB-INF/config/application-context.xml 에 <tx:annotation-driven> 태그 추가

[step13] - Transaction 처리하는 방법
3) AOP 기술을 이용하여 처리
=> application-context.xml 파일에 AOP 관련 태그 추가
   tx:advice, aop:config 
=> Service 클래스에서 @Transactional 애노테이션을 제거한다. 

[step14] - File Upload
=> board 테이블에 filepath 컬럼 추가
=> application-context.xml 파일에 멀티파트 요청 데이터를 처리하는 객체를 투입
=> BoardController 클래스 변경
=> Board 클래스 변경 
=> BoardDao.xml 변경

[step15] - 프론트 컨트롤러가 공통으로 사용하는 객체를 분리하여 별도로 준비한다.
=> ServletContextListener 구현체를 통해 공용 객체를 준비한다.
=> ContextLoaderListener를 web.xml에 등록한다.
=> ContextLoaderListener에서 준비할 개체 정보를 application-context.xml에 등록한다.
=> 페이지 컨트롤러와 웹 관련 객체들은 dispatcher-servlet.xml에 등록한다.













 