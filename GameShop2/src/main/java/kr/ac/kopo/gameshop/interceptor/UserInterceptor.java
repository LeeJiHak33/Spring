package kr.ac.kopo.gameshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.gameshop.model.Member;

public class UserInterceptor extends HandlerInterceptorAdapter {

	//로그인 가기전에 들렸다감
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession(); //세션(로그인 정보) 얻기
		Member member=(Member) session.getAttribute("member");
		if(member !=null) {
			System.out.println("UerInterCepctor: TRUE");
			return true;
		}
		
		String query=request.getQueryString();//쿼리스트링 받기
		session.setAttribute("target_url",request.getRequestURI()+(query !=null ? "?"+query : "") );
		System.out.println("interceptor"+session.getAttribute("target_url") );
		response.sendRedirect("/login");//로그인 페이지로 가라
		
		System.out.println("UerInterCepctor: FALSE");
		return false;
		
		
	}

}
