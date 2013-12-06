package fjs21.tarefas.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import fj21.tarefas.struts2.Usuario;


@SuppressWarnings("serial")
public class LoginInterceptor implements Interceptor {
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Usuario usuarioLogado=(Usuario) invocation.getInvocationContext().getSession().get("usuarioLogado");
		if(usuarioLogado==null){
		return "naoLogado";
		}else{
			return invocation.invoke();
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}


}
