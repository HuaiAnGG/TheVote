package wiki.laona.service.impl;

import wiki.laona.dao.IVoteDao;
import wiki.laona.dao.impl.VoteDaoImpl;
import wiki.laona.domain.Teacher;
import wiki.laona.service.IVoteService;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: TheVote
 * @description: 投票服务实现类
 * @author: HuaiAnGG
 * @create: 2020-11-20 15:15
 **/
public class VoteServiceImpl implements IVoteService<Teacher> {
    /**
     * vote dao
     */
    private IVoteDao<Teacher> voteDao = new VoteDaoImpl();

    /**
     * 投票
     *
     * @param id 老师编号
     */
    @Override
    public void vote(String id) {
        try {
            voteDao.updateVote(id);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * 获取所有老师的信息
     *
     * @return 所有老师信息
     */
    @Override
    public List<Teacher> getAllTeacherInfo() {
        List<Teacher> teacherList = null;
        try {
            teacherList = voteDao.getAll();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return teacherList;
    }

    /**
     * 获取老师信息通过老师编号
     *
     * @param id 老师编号
     */
    @Override
    public Teacher getTeacherInfoById(String id) {
        Teacher teacher = null;
        try {
            teacher = voteDao.getById(id);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return teacher;
    }

    /**
     * 获取投票比例
     *
     * @param id 老师编号
     * @return 投票比例
     */
    @Override
    public Integer getVoteProportion(String id) {
        return null;
    }
}
