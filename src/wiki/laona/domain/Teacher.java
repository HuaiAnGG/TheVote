package wiki.laona.domain;

/**
 * @program: TheVote
 * @description: teacher 类
 * @author: HuaiAnGG
 * @create: 2020-11-20 14:44
 **/
public class Teacher {
    /**
     * 老师编号
     */
    private String tea_id;
    /**
     * 老师姓名
     */
    private String tea_name;
    /**
     * 老师票数
     */
    private Integer vote;

    @Override
    public String toString() {
        return "Teacher{" +
                "tea_id='" + tea_id + '\'' +
                ", tea_name='" + tea_name + '\'' +
                ", vote=" + vote +
                '}';
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }
}
