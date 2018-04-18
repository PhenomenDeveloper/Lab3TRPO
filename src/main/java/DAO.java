import java.sql.*;



public class DAO {
    private static final String url = "jdbc:mysql://localhost:3306/ComputerManager";
    private static final String login = "root";
    private static final String password = "1234";
    private String response = "";
    private static Statement statement;


    public void Query (int select, String query, Computer computer) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(url,login,password);
            statement = connection.createStatement();
            System.out.println("gut");


            switch (select) {
                case 1: {
                    System.out.println(1);
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, computer.getCompMark());
                    statement.setString(2, computer.getCompModel());
                    statement.setString(3, String.valueOf(computer.getPrice()));
                    System.out.println(statement.toString());
                    statement.executeUpdate();
                    statement.close();
                    break;
                }

                case 2: {
                    System.out.println(2);
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {



          response = response + "<tr>" +
                                "<td>";
                        String compMark = rs.getString("COMP_MARK");
                        String compModel = rs.getString("COMP_MODEL");
                        String compPrice = rs.getString("COMP_PRICE");
                        response = response + compMark + "</td><td>";
                        response = response + compModel + "</td><TD>";
                        response = response + compPrice + "</TD>";
                        System.out.println(compMark + compModel + " " + compPrice);
                        response = response + "</TR>";
                    }

                    break;
                }

                case 3: {
                    System.out.println(3);
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, computer.getCompModel());
                    statement.executeUpdate();
                    statement.close();
                    break;
                }

                case 4: {
                    System.out.println(4);
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1,String.valueOf(computer.getPrice()));
                    statement.setString(2,computer.getCompModel());
                    statement.executeUpdate();
                    statement.close();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getResponse() {
        return response;
    }
}
