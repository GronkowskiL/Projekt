import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ITCompanySimulator {

    static LocalDate startingDate = LocalDate.of(2020, 1, 1);

    private LocalDate currentDate;


    private int budget;
    private ArrayList<Employee> employees;
    private ArrayList<Project> availableProjects;
    private ArrayList<Project> completedProjects;

    private ArrayList<Subcontractor> subcontractors;
    private int expenses;
    private int income;
    private int profit;

    public ITCompanySimulator(int budget) {
        this.budget = budget;
        this.employees = new ArrayList<Employee>();
        this.availableProjects = new ArrayList<Project>();
        this.completedProjects = new ArrayList<Project>();
        this.expenses = 0;
        this.income = 0;
        this.profit = 0;
    }

    public void run() {
        currentDate = startingDate;
        System.out.println(currentDate);

        currentDate = currentDate.plusDays(1);
        System.out.println(currentDate);

        System.out.println("Welcome to IT Company Simulator");
        System.out.println("You start with budget: $" + budget);
        System.out.println("You have " + employees.size() + " employee(s)");

        generateProjects();
        displayAvailableProjects();

        Scanner input = new Scanner(System.in);
        while (true) {
            currentDate = currentDate.plusDays(1);
            System.out.println(currentDate);
            System.out.println("\n\n");
            System.out.println("What do you want to do?");
            System.out.println("1. Hire employee");
            System.out.println("2. Accept project");
            System.out.println("3. Display completed projects");
            System.out.println("4. Display budget");
            System.out.println("5. Program");
            System.out.println("6. Test Code");
            System.out.println("7. Exit");




            if (currentDate.getDayOfMonth() % 5 == 0) {
                generateProjects();
                displayAvailableProjects();
            }

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
                    program();
                    break;
                case 6:
                    testCode();
                    break;
                case 7:
                    System.out.println("Exiting IT Company Simulator");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again");
            }
            currentDate = currentDate.plusDays(1);
        }
    }

    private void generateProjects() {
        Random random = new Random();
        int numberOfProjects = random.nextInt(10) + 5;

        for (int i = 0; i < numberOfProjects; i++) {
            double temp = Math.random();
            Project.Complexity complexity;
            if( temp < 0.33 ){
                complexity = Project.Complexity.difficult;
            } else if ( temp < 0.66) {
                complexity = Project.Complexity.medium;
            } else {
                complexity = Project.Complexity.easy;
            }

            int price = random.nextInt(10000) + 5000;
            int daysToComplete = random.nextInt(30) + 10;
            int daysToPay = random.nextInt(30) + 10;
            int clientType = random.nextInt(3) + 1;

            Client client = new Client(clientType);


            Project project = new Project(i, complexity, price, daysToComplete, daysToPay, client);
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


        String qualification = "";

        Employee newEmployee = new Employee(name, age, designation, qualification, salary);
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
    private void Turn() {
        Turn turn = new Turn();
        turn.work();
        turn.nextTurn();
        turn.work();

    }
    private void program() {
        System.out.println("Today is a programming day.");
    }
    private void testCode() {
        System.out.println("Testing code... ");
        System.out.println("Code testing finished.");
    }

}