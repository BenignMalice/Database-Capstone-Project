import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents a utility for displaying details of incomplete projects from the database.
 */

public class IncompleteProjects {
    private Connection connection;

    /**
     * Constructs an IncompleteProjects object with a specified database connection.
     *
     * @param connection The database connection.
     */
    
    public IncompleteProjects(Connection connection) {
        this.connection = connection;
    }

    /**
     * Displays details of projects that are in progress (not finalised) from the database.
     */
    
    public void displayIncompleteProjects() {
        try {
        	// Prepare and execute SQL query to retrieve incomplete projects
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Project " +
                "WHERE project_status <> 'finalised';"
            );

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("");
                System.out.println("Projects in progress:");
                System.out.println("---------------------");
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
                    System.out.println("Architect ID: " + resultSet.getInt("architect_id"));
                    System.out.println("Contractor ID: " + resultSet.getInt("contractor_id"));
                    System.out.println("Project Manager ID: " + resultSet.getInt("projectmanager_id"));
                    System.out.println("Structural Engineer ID: " + resultSet.getInt("structuraleng_id"));
                    System.out.println("");
                    System.out.println("-----------------------------");
                    System.out.println("");

                } while (resultSet.next());
            } else {
                System.out.println("No projects in progress found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
