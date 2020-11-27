package wiki.laona.web;

import wiki.laona.domain.Teacher;
import wiki.laona.service.impl.VoteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    private VoteServiceImpl voteService = new VoteServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        List<Teacher> teacherList = voteService.getAllTeacherInfo();
        req.setAttribute("teacherList", teacherList);

        int sum = 0;
        for (int i = 0; i < teacherList.size(); i++) {
            sum += teacherList.get(i).getVote();
        }
        Map<String, Integer> voteMap = new HashMap<>();
        for (int i = 0; i < teacherList.size(); i++) {
            Teacher teacher = teacherList.get(i);
            // System.out.println("teacher = " + teacher);
            int temp = (int) (1.0 * teacher.getVote() / sum * 100);
            // System.out.println("temp = " + temp);
            voteMap.put(teacherList.get(i).getTea_id(), temp);
        }

        req.setAttribute("voteMap", voteMap);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
