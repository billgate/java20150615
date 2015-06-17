[step01] - 기본 프로젝트를 Gradle 빌드 프로젝트로 포팅.

[step02] - Servlet + JSP + DAO + mybatis
* Mybatis
- persistence(지속성) framework
- JDBC 기능을 대행한다. 

[step03] - Servlet(x) Page Controller(Plain Old Java Object) 
           + JSP + DAO + Front Controller(서블릿)
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
           + Front Controller(서블릿)
           + Bean Container(= Object Manager) => Spring Bean Container
           





















 