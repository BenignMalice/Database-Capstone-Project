# Poise Project Management System

Poise Project Management System is a command-line application that allows users to manage construction projects and their details. It provides functionality to create, update, and delete project information, as well as manage project-related entities such as architects, contractors, project managers, and structural engineers.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Setup](#setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create new construction projects with details such as project name, building type, address, ERF number, project fee, etc.
- Update project details including project name, building type, project address, project deadline, and associated entities.
- Delete specific project details or the entire project, with confirmation prompts.
- Manage project-related entities such as architects, contractors, project managers, and structural engineers.
- User-friendly command-line interface for easy interaction.

## Getting Started

### Prerequisites

To run this application, you need:

- Java Development Kit (JDK) installed on your system.
- A relational database (e.g., MySQL) with the necessary schema and tables.

## Setup

1. Clone this repository to your local machine:

	```sh
	git clone https://github.com/BenignMalice/Database-Capstone-Project.git

2. Run MySQL

3. Compile the Java source code:
	cd construction-project-management
	javac Main.java

4. Configure the database connection in the Main.java file with your database credentials:

Database connection configuration: 

  String url = "jdbc:mysql://localhost:3306/PoisePMS";  
  String user = "your_username";  
 String password = "your_password";  
 
4. Create the necessary database schema and tables using SQL scripts provided.

## Usage

1. Open a terminal and navigate to the project directory.
2. Run the compiled Java program:
	java Main
3. Follow the prompts to create, update, or delete project details and related entities.
4. Use the menu options to perform various actions on the construction projects.

## Contributing
Contributions to this project are welcome! If you have any improvements or features you'd like to add, please feel free to open an issue or submit a pull request.
