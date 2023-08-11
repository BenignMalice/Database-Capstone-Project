import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * This class represents a utility for searching and displaying project details based on project number or name.
 */

public class FindProject {
    private Connection connection;

    /**
     * Constructs a FindProject object with a specified database connection.
     *
     * @param connection The database connection.
     */
    
    public FindProject(Connection connection) {
        this.connection = connection;
    }

    /**
     * Searches for projects in the database based on project number or name and displays their details.
     *
     * @param scanner The Scanner object to read user input.
     */
    
    public void searchProjects(Scanner scanner) {
        System.out.println("Enter project number or name to search: ");
        System.out.println("---------------------------------------");
        String searchTerm = scanner.nextLine();

        try {
        	// Prepare and execute SQL query
            PreparedStatement statement = connection.prepareStatement(
                "SELECT P.*, A.architect_name, C.contractor_name, PM.manager_name, SE.structuraleng_name " +
                "FROM Project P " +
                "LEFT JOIN Architect A ON P.architect_id = A.architect_id " +
                "LEFT JOIN Contractor C ON P.contractor_id = C.contractor_id " +
                "LEFT JOIN ProjectManager PM ON P.projectmanager_id = PM.projectmanager_id " +
                "LEFT JOIN StructuralEng SE ON P.structuraleng_id = SE.structuraleng_id " +
                "WHERE P.project_number = ? OR P.project_name LIKE ?"
            );
            statement.setString(1, searchTerm);
            statement.setString(2, "%" + searchTerm + "%");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("");
                System.out.println("Found matching project(s):");
                System.out.println("");
                do {
                    // Display all project details from the result set
                    System.out.println("Project Number: " + resultSet.getInt("project_number"));
                    System.out.println("Project Name: " + resultSet.getString("project_name"));
                    System.out.println("Building Type: " + resultSet.getString("building_type"));
                    System.out.println("Project Address: " + resultSet.getString("project_address"));
                    System.out.println("Erf Number: " + resultSet.getInt("erf_number"));
                    System.out.println("Total Project Fee: " + resultSet.getDouble("total_projectfee"));
                    System.out.println("Total Paid: " + resultSet.getDouble("total_paid"));
                    System.out.println("Project Deadline: " + resultSet.getString("project_deadline"));
                    System.out.println("Architect: " + resultSet.getString("architect_name"));
                    System.out.println("Contractor: " + resultSet.getString("contractor_name"));
                    System.out.println("Project Manager: " + resultSet.getString("manager_name"));
                    System.out.println("Structural Engineer: " + resultSet.getString("structuraleng_name"));
                    System.out.println("----------------------------------");
                } while (resultSet.next());
            } else {
                System.out.println("No matching project found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
