package wiki.laona.dao.impl;

import wiki.laona.dao.IVoteDao;
import wiki.laona.domain.Teacher;
import wiki.laona.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: TheVote
 * @description: 投票 dao 实现类
 * @author: HuaiAnGG
 * @create: 2020-11-20 14:50
 **/
public class VoteDaoImpl implements IVoteDao<Teacher> {
    /**
     * 获取所有信息
     *
     * @return 所有老师信息
     */
    @Override
    public List<Teacher> getAll() throws SQLException {
        String sqlStr = "select * from tb_vote";
        PreparedStatement preparedStatement = JdbcUtil.getConnectionInstance().prepareStatement(sqlStr);
        ResultSet rs = preparedStatement.executeQuery();
        List<Teacher> teacherList = new ArrayList<>();
        while (rs.next()) {
            Teacher teacher = new Teacher();
            String tea_id = rs.getString("tea_id");
            String tea_name = rs.getString("tea_name");
            int vote = rs.getInt("vote");
            teacher.setTea_id(tea_id);
            teacher.setTea_name(tea_name);
            teacher.setVote(vote);
            teacherList.add(teacher);
        }
        return teacherList;
    }

    /**
     * 通过 id  获取老师信息
     *
     * @param id 老师id
     * @return 老师信息
     */
    @Override
    public Teacher getById(String id) throws SQLException {
        String sqlStr = "select * from tb_vote where tea_id = ?";
        PreparedStatement preparedStatement = JdbcUtil.getConnectionInstance().prepareStatement(sqlStr);
        preparedStatement.setString(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Teacher teacher = null;
        if (rs.next()) {
            teacher = new Teacher();
            String tea_id = rs.getString("tea_id");
            String tea_name = rs.getString("tea_name");
            int vote = rs.getInt("vote");
            teacher.setTea_id(tea_id);
            teacher.setTea_name(tea_name);
            teacher.setVote(vote);
        }
        return teacher;
    }

    /**
     * 更新票数
     *
     * @param id 老师编号
     * @return 当前所有老师的票数
     * @throws SQLException
     */
    @Override
    public void updateVote(String id) throws SQLException {
        String sqlStr = "update tb_vote set vote = (vote + 1) where tea_id = ?";
        PreparedStatement preparedStatement = JdbcUtil.getConnectionInstance().prepareStatement(sqlStr);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }
}
