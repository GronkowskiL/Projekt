import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ITCompanySimulator {
    private int budget;
    private ArrayList<Employee> employees;
    private ArrayList<Project> availableProjects;
    private ArrayList<Project> completedProjects;

    public ITCompanySimulator(int budget) {
        this.budget = budget;
        this.employees = new ArrayList<Employee>();
        this.availableProjects = new ArrayList<Project>();
        this.completedProjects = new ArrayList<Project>();
    }

    public void run() {
        System.out.println("Welcome to IT Company Simulator");
        System.out.println("You start with budget: $" + budget);
        System.out.println("You have no employees");

        generateProjects();
        displayAvailableProjects();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Hire employee");
            System.out.println("2. Accept project");
            System.out.println("3. Display completed projects");
            System.out.println("4. Display budget");
            System.out.println("5. Exit");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    hireEmployee();
                    break;
                case 2:
                    acceptProject();
                    break;
                case 3:
                    displayCompletedProjects();
                    break;
                case 4:
                    displayBudget();
                    break;
                case 5:
                    System.out.println("Exiting IT Company Simulator");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private void generateProjects() {
        Random random = new Random();
        int numberOfProjects = random.nextInt(10) + 5;

        for (int i = 0; i < numberOfProjects; i++) {
            int complexity = random.nextInt(3) + 1;
            int price = random.nextInt(10000) + 5000;
            int daysToComplete = random.nextInt(30) + 10;
            int daysToPay = random.nextInt(30) + 10;
            int clientType = random.nextInt(3) + 1;

            Project project = new Project(i, complexity, price, daysToComplete, daysToPay, clientType);
            availableProjects.add(project);
        }
    }

    private void displayAvailableProjects() {
        System.out.println("Available projects: ");
        for (int i = 0; i < availableProjects.size(); i++) {
            System.out.println((i + 1) + ". " + availableProjects.get(i).getName());
        }
    }

    private void hireEmployee() {
        System.out.println("Enter the employee details: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter age: ");
        int age = sc.nextInt();

        System.out.println("Enter designation: ");
        sc.nextLine();
        String designation = sc.nextLine();

        System.out.println("Enter salary: ");
        double salary = sc.nextDouble();

        Employee newEmployee = new Employee(name, age, designation, salary);
        employees.add(newEmployee);

        System.out.println("Employee hired successfully: " + newEmployee);
    }

    private void acceptProject() {
        System.out.println("Enter project number to accept: ");
        Scanner sc = new Scanner(System.in);
        int projectNumber = sc.nextInt();

        Project selectedProject = availableProjects.get(projectNumber - 1);

        budget = budget - selectedProject.getPrice();
        availableProjects.remove(selectedProject);
        completedProjects.add(selectedProject);

        System.out.println("Project accepted successfully: " + selectedProject.getName());
    }

    private void displayCompletedProjects() {
        System.out.println("Completed projects: ");
        for (int i = 0; i < completedProjects.size(); i++) {
            System.out.println((i + 1) + ". " + completedProjects.get(i).getName());
        }
    }

    private void displayBudget() {
        System.out.println("Current budget: $" + budget);
    }

}