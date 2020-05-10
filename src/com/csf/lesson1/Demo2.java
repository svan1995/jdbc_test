package com.csf.lesson1;

import java.sql.*;

public class Demo2 {
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

        String sql = "insert into grade(`gradename`) values(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "研一");
        int i = preparedStatement.executeUpdate();
        if (i > 0)
            System.out.println("success");

        connection.close();

    }
}
