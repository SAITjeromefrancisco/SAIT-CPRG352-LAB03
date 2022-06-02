/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            String ageInput = request.getParameter("age_input");
            
            
            // do a simple try/catch for NumberFormatException to catch alphabetical inputs
            // this triggers the error message on catch
            // nomral code executes if nothing is caught
            try{
                if (ageInput == null || ageInput.equals("")){
                    request.setAttribute("message","You must give your currenet age");
                }else{
                    int intAge = Integer.parseInt(ageInput);
                    intAge++;
                    
                    request.setAttribute("message","Your age next birthday will be " + intAge);
                }
                 getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
                 return;
            }catch (NumberFormatException ex){
                request.setAttribute("message","You must enter a number");
                getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
                return;
            }
            
        
    }

}
