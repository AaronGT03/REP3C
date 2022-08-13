package com.example.demo.controller;
import com.example.demo.model.persona.BeanPersona;
import com.example.demo.service.persona.ServicePersona;
import com.example.demo.utils.ResultAction;

import javax.servlet.ServletConfig;
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

@WebServlet(name = "ServletPokemon",
        urlPatterns = {
                "/get-personas",
                "/add-persona",
                "/create-persona",
                "/save-persona",
                "/get-persona",
                "/delete-persona"
        })
public class ServletPersona extends HttpServlet {
    Logger logger = Logger.getLogger("ServletPokemon");
    String action;
    String urlRedirect = "/get-personas";
    ServicePersona servicePersona = new ServicePersona();



    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);
        switch (action) {
            case "/get-personas":
                List<BeanPersona> personas = servicePersona.getAll();
                System.out.println(personas.size());
                request.setAttribute("personas", personas);
                urlRedirect = "/index.jsp";
                break;
            case "/create-persona":
                urlRedirect = "/views/create.jsp";
                break;
            case "/get-persona":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                try {
                    BeanPersona persona = servicePersona.getPersona(Integer.parseInt(id));
                    request.setAttribute("persona", persona);
                    urlRedirect = "/views/update.jsp";
                } catch (Exception e) {
                    urlRedirect = "/get-personas";
                }
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
                    ResultAction result = servicePersona.save(persona);
                    urlRedirect = "/get-personas?result=" +
                            result.isResult() + "&message=" +
                            URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + result.getStatus();
                } catch (Exception e) {
                    Logger.getLogger(ServletPersona.class.getName()).log(Level.SEVERE,
                            "Error addPersona method" + e.getMessage());
                    urlRedirect = "/get-personas?result=false&message=" +
                            URLEncoder.encode("Error al registrar el pokemon",
                                    StandardCharsets.UTF_8.name())
                            + "&status=400";
                }
                break;

            default:
                urlRedirect = "/get-personas";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
