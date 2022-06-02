
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/math"})
public class ArithmeticCalculatorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // initialize result value
        request.setAttribute("message","---");
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticalcalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String firstInput = request.getParameter("first_input");
        String secondInput = request.getParameter("second_input");
        
        try{
            // force exception now because empty statements also show "invalid" message
            int first = Integer.parseInt(firstInput);
            int second = Integer.parseInt(secondInput);
            
            if (request.getParameter("+") != null){
                request.setAttribute("message",first+second);
            }else if (request.getParameter("-") != null){
                request.setAttribute("message",first-second);
            }else if (request.getParameter("*") != null){
                request.setAttribute("message",first*second);
            }else if (request.getParameter("%") != null){
                request.setAttribute("message",first%second);
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticalcalculator.jsp").forward(request, response);
            return;
        }catch (NumberFormatException ex){
            request.setAttribute("message","invalid");
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticalcalculator.jsp").forward(request, response);
                return;
        }
        
    }

}
