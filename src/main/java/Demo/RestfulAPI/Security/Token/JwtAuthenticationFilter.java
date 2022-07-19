package Demo.RestfulAPI.Security.Token;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import Demo.RestfulAPI.Security.MyUserDetail;
import Demo.RestfulAPI.Service.UserDetailService;



public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserDetailService userService;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = null;
		String token = null;
		MyUserDetail userDetails = null;

		token = getTokenFromRequest(request);

		if (token != null && tokenProvider.validateToken(token)) {
			username = tokenProvider.getUsernameFromToken(token);
			userDetails = (MyUserDetail) userService.loadUserByUsername(username);
			if (userDetails != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UsernamePasswordAuthenticationToken authentication =
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			
			if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
				org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				System.out.println(authentication.getAuthorities());
			}
		}
		filterChain.doFilter(request, response);
		
	}
	private String getTokenFromRequest(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null && token.startsWith("Bearer")) {
			return token.substring(7);
		}
		return null;
	}

}
