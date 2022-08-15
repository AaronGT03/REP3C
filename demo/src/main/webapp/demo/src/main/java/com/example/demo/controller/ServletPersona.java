package com.example.demo.controller;
import com.example.demo.model.persona.BeanPersona;
import com.example.demo.model.persona.DaoPersona;
import com.example.demo.service.persona.ServicePersona;
import com.example.demo.utils.ResultAction;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.*;
import java.sql.SQLException;

@WebServlet(name = "ServletPersona",
        urlPatterns = {
                "/get-personas",
                "/add-persona",
                "/create-persona",
                "/save-persona",
                "/get-persona",
                "/delete-persona"
        })
public class ServletPersona extends HttpServlet {
    Logger logger = Logger.getLogger("ServletPersona");
    String action;
    String urlRedirect = "/get-personas";

    DaoPersona daoPersona = new DaoPersona();
    ServicePersona servicePersona = new ServicePersona();




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);
        switch (action) {
            case "/get-personas":
                request.setAttribute("personas", servicePersona.getAll());
                urlRedirect = "/index.jsp";
                break;
            case "/create-persona":
                urlRedirect = "/views/create.jsp";
                break;
            case "/get-persona":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                try {
                    BeanPersona persona = servicePersona.getPersona(Long.parseLong(id));
                    request.setAttribute("persona", persona);
                    urlRedirect = "/views/edit.jsp";
                } catch (Exception e) {
                    urlRedirect = "/get-personas";
                }
                break;
            case "/add-persona":
                try {
                    String nombre = request.getParameter("nombre");
                    String surname = request.getParameter("surname");
                    String curp = request.getParameter("curp");
                    String cumple = request.getParameter("cumple");
                    BeanPersona persona = new BeanPersona();
                    persona.setNombre(nombre);
                    persona.setSurname(surname);
                    persona.setCurp(curp);
                    persona.setCumple(cumple);
                    System.out.println(persona.getNombre());
                    ResultAction rsElm = servicePersona.save(persona);
                    urlRedirect = "/get-personas?result=" +
                            rsElm.isResult() + "&message=" + URLEncoder.encode(rsElm.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + rsElm.getStatus();
                } catch (Exception e) {
                    urlRedirect = "/get-personas?result=false" + "&message="
                            + URLEncoder.encode(e.toString(), StandardCharsets.UTF_8.name())
                            + "&status=500";
                }
                break;
            case "/delete-persona":
                String idPersona = request.getParameter("id");
                ResultAction deleteResult = servicePersona.delete(idPersona);
                urlRedirect = "/get-personas?result=" +
                        deleteResult.isResult() + "&message=" +
                        URLEncoder.encode(deleteResult.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + deleteResult.getStatus();
                break;

            case "/save-persona":
                String nombre2 = request.getParameter("nombre");
                String surname2 = request.getParameter("surname");
                String curp2 = request.getParameter("curp");
                String cumple2 = request.getParameter("cumple");
                String id1 = request.getParameter("id");
                BeanPersona persona2 = new BeanPersona();
                persona2.setId(Long.parseLong(id1));
                persona2.setNombre(nombre2);
                persona2.setSurname(surname2);
                persona2.setCurp(curp2);
                persona2.setCumple(cumple2);
                ResultAction result2 = servicePersona.update(persona2);
                urlRedirect = "/get-personas?result=" +
                        result2.isResult() + "&message=" +
                        URLEncoder.encode(result2.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result2.getStatus();
                break;

            default:
                request.setAttribute("personas", servicePersona.getAll());
                urlRedirect = "/get-personas";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        action = request.getServletPath();
        switch (action) {
            case "/get-personas":
                String id2 = request.getParameter("id");
                daoPersona.delete(Long.parseLong(id2));
                urlRedirect = "/get-personas";
                break;


            default:
                urlRedirect = "/get-personas";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
