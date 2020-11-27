package wiki.laona.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: TheVote
 * @description: 投票 dao 接口
 * @author: HuaiAnGG
 * @create: 2020-11-20 14:47
 **/
public interface IVoteDao<T> {

    /**
     * 获取所有信息
     * @return 所有老师信息
     */
    List<T> getAll() throws SQLException;

    /**
     * 通过 id  获取老师信息
     * @param id 老师id
     * @return 老师信息
     */
    T getById(String id) throws SQLException;


    /**
     * 更新票数
     * @param id 老师编号
     * @throws SQLException
     */
    void updateVote(String id) throws SQLException;
}
