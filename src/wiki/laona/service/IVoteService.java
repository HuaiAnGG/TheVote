package wiki.laona.service;

import wiki.laona.domain.Teacher;

import java.util.List;

/**
 * @program: TheVote
 * @description: 投票接口
 * @author: HuaiAnGG
 * @create: 2020-11-20 14:45
 **/
public interface IVoteService<T> {

    /**
     * 投票
     *
     * @param t
     */
    void vote(String id);

    /**
     * 获取所有老师的信息
     *
     * @return 所有老师信息
     */
    List<T> getAllTeacherInfo();


    /**
     * 获取老师信息通过老师编号
     *
     * @param id 老师编号
     */
    T getTeacherInfoById(String id);


    /**
     * 获取投票比例
     * @param id 老师编号
     * @return 投票比例
     */
    Integer getVoteProportion(String id);
}
