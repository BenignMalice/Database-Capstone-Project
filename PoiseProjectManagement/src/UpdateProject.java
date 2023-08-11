import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * This class represents a utility for updating or deleting project information in the database.
 */

public class UpdateProject {
    private Connection connection;
    
    /**
     * Constructs an UpdateProject object with a specified database connection.
     *
     * @param connection The database connection.
     */
    
    public UpdateProject(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * Allows the user to update or delete project information based on user input.
     *
     * @param scanner The Scanner object for user input.
     */
    
    public void updateProject(Scanner scanner) {
        System.out.println("Enter project number to update: ");
        int projectNumber = scanner.nextInt();
        scanner.nextLine();
        
        try {
        	// Prepare a SELECT statement to retrieve project details
            PreparedStatement selectStatement = connection.prepareStatement(
                "SELECT * FROM Project WHERE project_number = ?"
            );
            selectStatement.setInt(1, projectNumber);

            // Execute the SELECT statement
            ResultSet resultSet = selectStatement.executeQuery();
            
            if (resultSet.next()) {
            	// Print current project details
                System.out.println("Current Project Details:");
                System.out.println("Project Number: " + resultSet.getInt("project_number"));
                System.out.println("Project Name: " + resultSet.getString("project_name"));
                System.out.println("Building Type: " + resultSet.getString("building_type"));
                System.out.println("Project Address: " + resultSet.getString("project_address"));
                System.out.println("ERF Number: " + resultSet.getInt("erf_number"));
                System.out.println("Total Project Fee: " + resultSet.getDouble("total_projectfee"));
                System.out.println("Total Paid: " + resultSet.getDouble("total_paid"));
                System.out.println("Project Deadline: " + resultSet.getDate("project_deadline"));
                System.out.println("Architect: " + resultSet.getInt("architect_id"));
                System.out.println("Contractor: " + resultSet.getInt("contractor_id"));
                System.out.println("Project Manager: " + resultSet.getInt("projectmanager_id"));
                System.out.println("Structural Engineer: " + resultSet.getInt("structuraleng_id"));
                System.out.println("");
                
                System.out.println("Choose an option:");
                // Print options
                System.out.println("1. Update project name");
                System.out.println("2. Update building type");
                System.out.println("3. Update project address");
                System.out.println("4. Update ERF number");
                System.out.println("5. Update total project fee");
                System.out.println("6. Update total paid amount");
                System.out.println("7. Update project deadline");
                System.out.println("8. Update Architect");
                System.out.println("9. Update Contractor");
                System.out.println("10. Update Project Manager");
                System.out.println("11. Update Structural Engineer");
                System.out.println("");              
                System.out.println("12. Delete project name");
                System.out.println("13. Delete building type");
                System.out.println("14. Delete project address");
                System.out.println("15. Delete ERF number");
                System.out.println("16. Delete total project fee");
                System.out.println("17. Delete total paid amount");
                System.out.println("18. Delete project deadline");
                System.out.println("19. Delete Architect");
                System.out.println("20. Delete Contractor");
                System.out.println("21. Delete Project Manager");
                System.out.println("22. Delete Structural Engineer");
                System.out.println("23. Delete Entire Project");
                System.out.println("");         
                
                int option = scanner.nextInt();
                scanner.nextLine();
                
                PreparedStatement updateStatement = null;
                String successMessage = "Field updated/deleted successfully.";
                
                switch (option) {
                    case 1:
                    	// Update project name
                    	System.out.println("Enter updated project name: ");
                        String updatedName = scanner.nextLine();
                        if (!updatedName.isEmpty()) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET project_name = ? WHERE project_number = ?"
                            );
                            updateStatement.setString(1, updatedName);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 2:
                        // Update building type
                        System.out.println("Enter updated building type: ");
                        String updatedBuildingType = scanner.nextLine();
                        if (!updatedBuildingType.isEmpty()) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET building_type = ? WHERE project_number = ?"
                            );
                            updateStatement.setString(1, updatedBuildingType);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 3:
                        // Update project address
                        System.out.println("Enter updated project address: ");
                        String updatedAddress = scanner.nextLine();
                        if (!updatedAddress.isEmpty()) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET project_address = ? WHERE project_number = ?"
                            );
                            updateStatement.setString(1, updatedAddress);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 4:
                        // Update ERF number
                        System.out.println("Enter updated ERF number: ");
                        int updatedErfNumber = scanner.nextInt();
                        scanner.nextLine();
                        if (updatedErfNumber > 0) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET erf_number = ? WHERE project_number = ?"
                            );
                            updateStatement.setInt(1, updatedErfNumber);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 5:
                        // Update total project fee
                        System.out.println("Enter updated total project fee: ");
                        double updatedProjectFee = scanner.nextDouble();
                        scanner.nextLine();
                        if (updatedProjectFee >= 0) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET total_projectfee = ? WHERE project_number = ?"
                            );
                            updateStatement.setDouble(1, updatedProjectFee);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 6:
                        // Update total paid amount
                        System.out.println("Enter updated total paid amount: ");
                        double updatedTotalPaid = scanner.nextDouble();
                        scanner.nextLine();
                        if (updatedTotalPaid >= 0) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET total_paid = ? WHERE project_number = ?"
                            );
                            updateStatement.setDouble(1, updatedTotalPaid);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 7:
                        // Update project deadline
                        System.out.println("Enter updated project deadline (YYYY-MM-DD): ");
                        String updatedDeadline = scanner.nextLine();
                        if (!updatedDeadline.isEmpty()) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET project_deadline = ? WHERE project_number = ?"
                            );
                            updateStatement.setString(1, updatedDeadline);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 8:
                    	// Update Architect
                        System.out.println("Enter updated Architect ID (or press Enter to keep current): ");
                        String updatedArchitectID = scanner.nextLine();
                        if (!updatedArchitectID.isEmpty()) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET architect_id = ? WHERE project_number = ?"
                            );
                            updateStatement.setString(1, updatedArchitectID);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 9:
                    	// Update Contractor
                        System.out.println("Enter updated Contractor ID (or press Enter to keep current): ");
                        String updatedContractorID = scanner.nextLine();
                        if (!updatedContractorID.isEmpty()) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET contractor_id = ? WHERE project_number = ?"
                            );
                            updateStatement.setString(1, updatedContractorID);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 10:
                    	// Update Project Manager
                        System.out.println("Enter updated Project Manager ID (or press Enter to keep current): ");
                        String updatedProjectManagerID = scanner.nextLine();
                        if (!updatedProjectManagerID.isEmpty()) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET projectmanager_id = ? WHERE project_number = ?"
                            );
                            updateStatement.setString(1, updatedProjectManagerID);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                    case 11:
                    	// Update Structural Engineer
                        System.out.println("Enter updated Structural Engineer ID (or press Enter to keep current): ");
                        String updatedStructuralEngineerID = scanner.nextLine();
                        if (!updatedStructuralEngineerID.isEmpty()) {
                            updateStatement = connection.prepareStatement(
                                "UPDATE Project SET structuraleng_id = ? WHERE project_number = ?"
                            );
                            updateStatement.setString(1, updatedStructuralEngineerID);
                            updateStatement.setInt(2, projectNumber);
                            updateStatement.executeUpdate();
                        }
                        break;
                        
                    case 12:
                        // Delete project name
                        PreparedStatement deleteNameStatement = connection.prepareStatement(
                            "UPDATE Project SET project_name = NULL WHERE project_number = ?"
                        );
                        deleteNameStatement.setInt(1, projectNumber);
                        deleteNameStatement.executeUpdate();
                        break;
                    case 13:
                        // Delete building type
                        PreparedStatement deleteTypeStatement = connection.prepareStatement(
                            "UPDATE Project SET building_type = NULL WHERE project_number = ?"
                        );
                        deleteTypeStatement.setInt(1, projectNumber);
                        deleteTypeStatement.executeUpdate();
                        break;
                    case 14:
                        // Delete project address
                        PreparedStatement deleteAddressStatement = connection.prepareStatement(
                            "UPDATE Project SET project_address = NULL WHERE project_number = ?"
                        );
                        deleteAddressStatement.setInt(1, projectNumber);
                        deleteAddressStatement.executeUpdate();
                        break;
                    case 15:
                        // Delete ERF number
                        PreparedStatement deleteErfStatement = connection.prepareStatement(
                            "UPDATE Project SET erf_number = NULL WHERE project_number = ?"
                        );
                        deleteErfStatement.setInt(1, projectNumber);
                        deleteErfStatement.executeUpdate();
                        break;
                    case 16:
                        // Delete total project fee
                        PreparedStatement deleteFeeStatement = connection.prepareStatement(
                            "UPDATE Project SET total_projectfee = NULL WHERE project_number = ?"
                        );
                        deleteFeeStatement.setInt(1, projectNumber);
                        deleteFeeStatement.executeUpdate();
                        break;
                    case 17:
                        // Delete total paid amount
                        PreparedStatement deletePaidStatement = connection.prepareStatement(
                            "UPDATE Project SET total_paid = NULL WHERE project_number = ?"
                        );
                        deletePaidStatement.setInt(1, projectNumber);
                        deletePaidStatement.executeUpdate();
                        break;
                    case 18:
                        // Delete project deadline
                        PreparedStatement deleteDeadlineStatement = connection.prepareStatement(
                            "UPDATE Project SET project_deadline = NULL WHERE project_number = ?"
                        );
                        deleteDeadlineStatement.setInt(1, projectNumber);
                        deleteDeadlineStatement.executeUpdate();
                        break;
                    case 19:
                        // Delete Architect
                        PreparedStatement deleteArchitectStatement = connection.prepareStatement(
                            "UPDATE Project SET architect_id = NULL WHERE project_number = ?"
                        );
                        deleteArchitectStatement.setInt(1, projectNumber);
                        deleteArchitectStatement.executeUpdate();
                        break;

                    case 20:
                        // Delete Contractor
                        PreparedStatement deleteContractorStatement = connection.prepareStatement(
                            "UPDATE Project SET contractor_id = NULL WHERE project_number = ?"
                        );
                        deleteContractorStatement.setInt(1, projectNumber);
                        deleteContractorStatement.executeUpdate();
                        break;

                    case 21:
                        // Delete Project Manager
                        PreparedStatement deleteProjectManagerStatement = connection.prepareStatement(
                            "UPDATE Project SET projectmanager_id = NULL WHERE project_number = ?"
                        );
                        deleteProjectManagerStatement.setInt(1, projectNumber);
                        deleteProjectManagerStatement.executeUpdate();
                        break;

                    case 22:
                        // Delete Structural Engineer
                        PreparedStatement deleteStructuralEngineerStatement = connection.prepareStatement(
                            "UPDATE Project SET structuraleng_id = NULL WHERE project_number = ?"
                        );
                        deleteStructuralEngineerStatement.setInt(1, projectNumber);
                        deleteStructuralEngineerStatement.executeUpdate();
                        break;
                        
                    case 23:
                        // Delete entire project
                        System.out.println("Are you sure you want to delete the entire project? (yes/no): ");
                        String confirmation = scanner.nextLine();
                        if (confirmation.equalsIgnoreCase("yes")) {
                            PreparedStatement deleteProjectStatement = connection.prepareStatement(
                                "DELETE FROM Project WHERE project_number = ?"
                            );
                            deleteProjectStatement.setInt(1, projectNumber);
                            deleteProjectStatement.executeUpdate();
                            System.out.println("Project deleted successfully.");
                            System.out.println("");
                        } else {
                            System.out.println("Deletion canceled.");
                            System.out.println("");
                        }
                        break;
                        
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
                
                if (updateStatement != null) {
                    try {
                        updateStatement.executeUpdate();
                        System.out.println(successMessage);
                        System.out.println("");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Project not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}