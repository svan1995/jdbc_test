package com.csf.lesson1;

import javax.sql.DataSource;
import java.sql.*;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://129.211.33.43:3306/school?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String userName = "root";
        String password = "XXX";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = connection.createStatement();

        String sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("姓名: "+resultSet.getObject("studentname"));
        }

        resultSet.close();
        statement.close();
        connection.close();


    }
}
