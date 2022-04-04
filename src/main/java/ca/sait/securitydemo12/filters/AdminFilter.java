
package ca.sait.securitydemo12.filters;

import ca.sait.securitydemo12.models.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 752808
 */
public class AdminFilter implements Filter {
    
 

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

   HttpServletRequest httpRequest = (HttpServletRequest) request;
   HttpServletResponse httpResponse = (HttpServletResponse) response;

   User user = new User(request.getParameter("email"));
      
   int roleId = user.getRole().getRoleId();
      
        if( roleId == 1) {
           chain.doFilter(request, response); 
        }
        else if ( roleId == 2) {
            httpResponse.sendRedirect("/notes");
        }


        
       
    }

    
    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
       }

    
}
