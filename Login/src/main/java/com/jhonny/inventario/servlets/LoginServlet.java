package com.jhonny.inventario.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jhonny.inventario.dao.UsuarioDAO;
import com.jhonny.inventario.model.Usuario;

public class LoginServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    /** 1) Manejo de CORS para preflight */
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setCors(resp);
    }

    /** 2) Procesa el POST de login */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Habilita CORS
        setCors(resp);

        // Marca la entrada
        System.out.println(">>> LoginServlet.doPost invoked <<<");
        try {
            // Leer JSON
            BufferedReader reader = req.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("Received payload: " + sb);

            JSONObject json = new JSONObject(sb.toString());
            String username = json.get("username").toString();
            String password = json.get("password").toString();

            // Buscar usuario
            Usuario u = usuarioDAO.findByUsername(username);
            System.out.println("Usuario from DAO: " + u);

            // Si válido, crea sesión
            if (u != null && u.getContrasena().equals(password)) {
                HttpSession session = req.getSession(true);
                session.setAttribute("usuario", username);
                System.out.println("Login correcto para " + username);
            } else {
                System.out.println("Login fallido para " + username);
            }

            // Responder JSON
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            JSONObject respJson = new JSONObject();
            if (u != null && u.getContrasena().equals(password)) {
                respJson.put("success", true).put("message", "Login correcto");
            } else {
                respJson.put("success", false).put("message", "Usuario o contraseña incorrectos");
            }
            out.print(respJson.toString());
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /** 3) Helper para agregar cabeceras CORS */
    private void setCors(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        resp.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
    }
}