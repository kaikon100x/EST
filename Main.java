import java.sql.*;

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employeedb";
        String user = "root";
        String pass = "Sahil007#";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Employee");

            System.out.println("Employee Data:");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("role") + " | " +
                    rs.getDouble("salary")
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Animal a;
        a = new Dog();
        a.sound();
        a = new Cat();
        a.sound();
    }
}