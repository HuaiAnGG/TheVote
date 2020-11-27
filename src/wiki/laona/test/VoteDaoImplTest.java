package wiki.laona.test;


import org.junit.Test;
import wiki.laona.dao.impl.VoteDaoImpl;
import wiki.laona.domain.Teacher;
import wiki.laona.service.impl.VoteServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class VoteDaoImplTest {

    @Test
    public void getAll() {
        VoteDaoImpl voteDao = new VoteDaoImpl();
        List<Teacher> all = null;
        try {
            all = voteDao.getAll();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        System.out.println("all = " + all);
    }

    @Test
    public void getById() {
    }

    @Test
    public void voteById() {

        VoteServiceImpl voteService = new VoteServiceImpl();
        voteService.vote("1002");
    }
}