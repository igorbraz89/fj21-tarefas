package fj21.tarefas.interceptor;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import fj21.tarefas.struts2.Usuario;


@InterceptorRef("login")
public class LoginInterceptor implements Interceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		Usuario usuarioLogado=(Usuario) invocation.getInvocationContext().getSession().get("usuarioLogado");
		if(usuarioLogado==null){
		return "naoLogado";
		}else{
			return invocation.invoke();
		}
	}
	public void destroy() {
		
	}
	
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
