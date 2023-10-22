/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package make.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class App extends JFrame{
    final int WIDTH = 300, HEIGHT = 300;

    App(){
        JButton hello = new JButton("넌 뭐야");
        add(hello);

        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setTitle("테스트");
    }

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306",
                    "root",
                    "1234"
            );

            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "show databases"
            );

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new App();
    }
}
