package com.stefanini.hackaton.rest.config;

/*@WebFilter("/*")
public class RequestFilter implements Filter{
	
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest httpServletRequest = (HttpServletRequest)request;
			
			if (httpServletRequest.getContextPath().contains("/autenticar")) {
				 chain.doFilter(request, response); 
				//doFilter(request, response, chain);
				
			} else if(httpServletRequest.getSession().getAttribute("USER") == null) {
				throw new NotAuthorizedException("Permissão negada!");
				
			} else {
				doFilter(request, response, chain);
			}
			
		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {
			// TODO Auto-generated method stub
			
		}
}*/
