package com.spring.jean.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "VideoServlet", value = "/videoFile")
public class VideoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public VideoServlet() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (
                InputStream videoStream = getServletContext().getResourceAsStream("/WEB-INF/videos/tuzabyina.mp4");
                OutputStream outputStream = response.getOutputStream()
        ){
            response.setContentType("video/mp4");
            response.setHeader("Content-Disposition", "inline; filename=tuzabyina.mp4");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = videoStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            videoStream.close();
            outputStream.flush();
        }
        catch (IOException ex) {
            throw new ServletException(ex);
        }
    }
}
