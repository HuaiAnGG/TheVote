<%--
  Created by IntelliJ IDEA.
  User: huaian
  Date: 2020/11/20
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="teacherList" type="java.util.ArrayList" scope="request"/>
<jsp:useBean id="voteMap" type="java.util.HashMap<java.lang.String, java.lang.Integer>" scope="request"/>
<html>
<style>
  .container {
    width: 800px;
    margin: 0 auto;
    background-color: #f0f0f0;
  }

  .container tr{
      height: 50px;
      /*background-color: red;*/
  }

  .container tr td{
      width: 80px;
      height: 100%;
      background-color: cyan;
  }

</style>
<head>
    <title>投票页面</title>
</head>
<body>
<div class="container">
    <h3 style="margin: 0 auto; width: 100%; text-align: center" >培正老师选举投票</h3>
    <table style="margin: 0 auto;">
        <tr style="width: 100px;">
            <td style="width: 100px;">老师编号</td>
            <td style="width: 100px;">老师名字</td>
            <td style="width: 100px;">票数</td>
            <td style="width: 100px;">比例</td>
            <td style="width: 100px;">投票</td>
        </tr>
        <br>
        <c:forEach items="${ requestScope.teacherList }" var="teacher" varStatus="status">
            <tr>
                <td>${teacher.tea_id}</td>
                <td>${teacher.tea_name}</td>
                <td>${teacher.vote}</td>
                <td>
                        <div style="height: 100%; width: ${voteMap.get(teacher.tea_id)}px; background-color:red;" >
                                ${voteMap.get(teacher.tea_id)}%
                        </div>
                </td>
                <td>
                    <a class="a_submit" href="#">投票</a>
                    <form action="${pageContext.request.contextPath}/vote" method="post" class="vote_from">
                        <input name="tea_id" value="${teacher.tea_id}" hidden>
<%--                        <input type="submit" value="投票">--%>
                    </form>
                </td>
            </tr>
            <br>

        </c:forEach>
    </table>
</div>


<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">

    /**
     * class 使用 .
     * id 使用 #
     */
    $(function () {

        $('.a_submit').click(function () {
            // $(this).siblings('.vote_from').submit();
            // ajax
            $.post('${pageContext.request.contextPath}/vote', $(this).siblings('.vote_from').serialize());
        });
    });


</script>
</body>
</html>
