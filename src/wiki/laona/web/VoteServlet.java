package wiki.laona.web;

import wiki.laona.domain.Teacher;
import wiki.laona.service.impl.VoteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {

    private VoteServiceImpl voteService = new VoteServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("VoteServlet.service");
        String id = req.getParameter("tea_id");
        System.out.println("id = " + id);

        voteService.vote(id);

        req.getRequestDispatcher("/index").forward(req, resp);
    }
}
