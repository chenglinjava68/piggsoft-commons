package com.piggsoft.comms.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.piggsoft.comms.utils.Constants;

public class PiggsoftAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		boolean isAjax = isAjaxRequest(request);
		if(!isAjax){
            request.setAttribute(Constants.REQUEST_KEY_IS_AJAX_REQUEST, isAjax);
            request.setAttribute(Constants.REQUEST_KEY_MESSAGE, accessDeniedException.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/authNotPass.jsp");
            dispatcher.forward(request, response);
        }else{
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            response.getWriter().write("权限不足");
            response.getWriter().close();
        }
	}
	
	private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        if (header != null && "XMLHttpRequest".equals(header))
            return true;
        else
            return false;
    }
}
