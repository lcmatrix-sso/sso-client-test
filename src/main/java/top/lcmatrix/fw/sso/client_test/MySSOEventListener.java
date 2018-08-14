package top.lcmatrix.fw.sso.client_test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import top.lcmatrix.fw.sso.client.entity.TokenObject;
import top.lcmatrix.fw.sso.client.listener.SSOEventListener;
import top.lcmatrix.fw.sso.client_test.entity.User;

@Component
public class MySSOEventListener implements SSOEventListener{

	@Override
	public void onValidateSuccess(TokenObject tokenObject, HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 验证成功后，将user对象存储到session中
		 */
		request.getSession().setAttribute("user", tokenObject.getUser(User.class));
	}

}
