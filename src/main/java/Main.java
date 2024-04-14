import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;



public class Main {

    public int typeofUser(){
        Scanner scanner = new Scanner (System.in);
        int typeOfUser = 0;
        while (typeOfUser != 1 && typeOfUser != 2 && typeOfUser != 3 && typeOfUser != 4) {
            System.out.println();
            System.out.println("Are you a Member, Trainer, or Administrative staff?");
            System.out.println("Enter 1 for Member, 2 for Trainer, 3 for Administrative staff, 4 to exit:");

            // Capture user input
            if (scanner.hasNextInt()) {
                typeOfUser = scanner.nextInt();
            } else {
                // If input is not an integer, consume the invalid input
                scanner.next();
            }

            // Check if input is invalid
            if (typeOfUser != 1 && typeOfUser != 2 && typeOfUser != 3 && typeOfUser != 4) {
                System.out.println();
                System.out.println("Invalid option. Please enter 1, 2, 3, or 4.");
                System.out.println();
            }
        }
        return typeOfUser;
    }

    public int memberTypeOfUser(){
        Scanner scanner = new Scanner (System.in);
        int functionNumber = 0;
        while (functionNumber != 1 && functionNumber != 2 && functionNumber != 3 && functionNumber != 4 && functionNumber != 5){
            System.out.println("1. Would you like to register as a new member? ");
            System.out.println("2. Update personal information, fitness goals, and health metric");
            System.out.println("3. View Dashboard");
            System.out.println("4. Schedule, reschedule, or cancel training session");
            System.out.println("5. Exit from member");

            if (scanner.hasNextInt()) {
                functionNumber = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (functionNumber != 1 && functionNumber != 2 && functionNumber != 3 && functionNumber != 4 && functionNumber != 5) {
                System.out.println();
                System.out.println("Invalid option. Please enter 1, 2, 3, 4, or 5.");
                System.out.println();
            }

        }
        return functionNumber;
    }

    public int trainerTypeOfUser(){
        Scanner scanner = new Scanner (System.in);
        int functionTrainerNumber = 0;
        while (functionTrainerNumber != 1 && functionTrainerNumber != 2 && functionTrainerNumber != 3){
            System.out.println("1. Would you like to manage your schedule? ");
            System.out.println("2. Would you like to view a member's profile? ");
            System.out.println("3. Exit from trainer");

            if (scanner.hasNextInt()) {
                functionTrainerNumber = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (functionTrainerNumber != 1 && functionTrainerNumber != 2 && functionTrainerNumber != 3) {
                System.out.println();
                System.out.println("Invalid option. Please enter 1, 2, or 3");
                System.out.println();
            }

        }
        return functionTrainerNumber;
    }

    public int adminTypeOfUser(){
        Scanner scanner = new Scanner (System.in);
        int functionAdminNumber = 0;
        while (functionAdminNumber != 1 && functionAdminNumber != 2 && functionAdminNumber != 3 && functionAdminNumber != 4 && functionAdminNumber != 5){
            System.out.println("1. Would you like to manage room bookings? ");
            System.out.println("2. Would you like to monitor fitness equipment maintenance? ");
            System.out.println("3. Would you like to update class schedules? ");
            System.out.println("4. Would you like to process payments for membership fees, personal training sessions, and other services? ");
            System.out.println("5. Exit from admin");

            if (scanner.hasNextInt()) {
                functionAdminNumber = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (functionAdminNumber != 1 && functionAdminNumber != 2 && functionAdminNumber != 3 && functionAdminNumber != 4 && functionAdminNumber != 5) {
                System.out.println();
                System.out.println("Invalid option. Please enter 1, 2, 3, 4, or 5");
                System.out.println();
            }

        }
        return functionAdminNumber;
    }

    public void addMember(String first_nameMember, String last_nameMember, int weightGoal, int timeGoal, int restingHeartRate, double bmi) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "INSERT INTO member (first_name, last_name, weight_goal, time_goal, resting_heart_rate, BMI) " +
                    "VALUES ('" + first_nameMember + "', '" + last_nameMember + "', " + weightGoal + ", " + timeGoal + ", " + restingHeartRate + ", " + bmi + ")";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void getTrainingSession() {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeQuery("SELECT * FROM training_session ORDER BY session_id");
            ResultSet resultSet = statement.getResultSet();

            //Will get all the information for the students and output it
            while (resultSet.next()) {
                int sessionId = resultSet.getInt("session_id");
                String type = resultSet.getString("type_pg");
                String timeSlot = resultSet.getString("time_slot");
                String trainerId = resultSet.getString("trainer_id");

                System.out.println("Available training sessions: ");
                System.out.println("Session ID: "+ sessionId);
                System.out.println("Type: " + type);
                System.out.println("Time Slot: " + timeSlot);
                System.out.println("Trainer Id: " + trainerId);
                System.out.println();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public int getMemberId(String firstName, String lastName){
        int memberId = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeQuery("SELECT member_id FROM member WHERE first_name = '" + firstName + "' AND last_name = '" + lastName + "'");
            ResultSet resultSet = statement.getResultSet();

            //Will get all the information for the students and output it
            while (resultSet.next()) {
                memberId = resultSet.getInt("member_id");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return memberId;
    }

    public int getTrainerId(String firstName, String lastName){
        int trainerId = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeQuery("SELECT trainer_id FROM trainer WHERE first_name = '" + firstName + "' AND last_name = '" + lastName + "'");
            ResultSet resultSet = statement.getResultSet();

            //Will get all the information for the students and output it
            while (resultSet.next()) {
                trainerId = resultSet.getInt("trainer_id");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return trainerId;
    }

    public void updateTrainingSession(int memberId, int sessionId) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "UPDATE training_session SET member_id = " + memberId + " WHERE session_id = " + sessionId;


            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateMemberProfile (int memberIDCase2, int newWeightGoal, int newTimeGoal, int newRestingHeartRate, double newBmi){
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "UPDATE member SET " +
                    "weight_goal = " + newWeightGoal + ", " +
                    "time_goal = " + newTimeGoal + ", " +
                    "resting_heart_rate = " + newRestingHeartRate + ", " +
                    "bmi = " + newBmi + " " +
                    "WHERE member_id = " + memberIDCase2;

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public void addPayment(double amount, String status_update, String date_record, String member_id) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "INSERT INTO payment (amount, status_update, date_record, member_id) " +
                    "VALUES (" + amount + ", '" + status_update + "', '" + date_record + "', " + member_id + ")";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void addDashboard(int memberID, int restingHeartRate, double bmi) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "INSERT INTO dashboard (member_id, km_to_run, number_of_pushups, weight_lost, steps_walked_per_day, resting_heart_rate, BMI) " +
                    "VALUES (" + memberID + ", 9, 15, 5, 7100, " + restingHeartRate + ", " + bmi + ")";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void getDashboard(int memberId) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeQuery("SELECT * FROM dashboard WHERE member_id = " + memberId);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                int member_id = resultSet.getInt("member_id");
                int kmToRun = resultSet.getInt("km_to_run");
                int numberOfPushups = resultSet.getInt("number_of_pushups");
                int weightLost = resultSet.getInt("weight_lost");
                int stepsWalkedPerDay = resultSet.getInt("steps_walked_per_day");
                int restingHeartRate = resultSet.getInt("resting_heart_rate");
                double bmi = resultSet.getDouble("bmi");

                System.out.println();
                System.out.println("Member ID: "+ member_id);
                System.out.println("Km to run: " + kmToRun);
                System.out.println("Number of pushups: " + numberOfPushups);
                System.out.println("Weight lost: " + weightLost);
                System.out.println("Steps walked per day (7-day average): " + stepsWalkedPerDay);
                System.out.println("Resting heart rate: " + restingHeartRate);
                System.out.println("BMI: " + bmi);


            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void removeTrainingSession(int memberId){
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "UPDATE training_session SET member_id = 0 WHERE member_id = " + memberId;


            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void addTrainingSession(String typePG, String timeSlot, int trainerID) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "INSERT INTO training_session (type_PG, time_slot, trainer_id, member_id) " +
                    "VALUES ('" + typePG + "', '" + timeSlot + "', " + trainerID + ", + 0)";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void getMemberProfile(String firstName, String lastName) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeQuery("SELECT * FROM member WHERE first_name = '" + firstName + "' AND last_name = '" + lastName + "'");

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                int member_id = resultSet.getInt("member_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int weight_goal = resultSet.getInt("weight_goal");
                int time_goal = resultSet.getInt("time_goal");
                int resting_heart_rate = resultSet.getInt("resting_heart_rate");
                double bmi = resultSet.getDouble("bmi");

                System.out.println();
                System.out.println("Member ID: "+ member_id);
                System.out.println("First name: " + first_name);
                System.out.println("Last name: " + last_name);
                System.out.println("Weight goal in kg: " + weight_goal);
                System.out.println("Time goal in seconds: " + time_goal);
                System.out.println("Resting heart rate: " + resting_heart_rate);
                System.out.println("BMI: " + bmi);
                System.out.println();


            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void manageRoom(String name_info, String status_update, int capacity) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "UPDATE room SET status_update = '" + status_update + "', capacity = " + capacity + " WHERE name_info = '" + name_info + "'";


            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void manageEquipment(String name_info, String status_update, String lastMaintenanceDate) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "UPDATE equipment SET status_update = '" + status_update + "', last_maintanence_date = '" + lastMaintenanceDate + "' WHERE name_info = '" + name_info + "'";


            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void updateAdminTrainingSession(int session_id, String type_pg, String time_slot) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "UPDATE training_session SET type_pg = '" + type_pg + "', time_slot = '" + time_slot + "' WHERE session_id = " + session_id;


            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void getPaymentData() {
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeQuery("SELECT * FROM Payment;");

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                int payment_id = resultSet.getInt("payment_id");
                double amount = resultSet.getDouble("amount");
                String status_update = resultSet.getString("status_update");
                String date_record = resultSet.getString("date_record");
                int member_id = resultSet.getInt("member_id");

                System.out.println();
                System.out.println("Payment ID: "+ payment_id);
                System.out.println("Amount: " + amount);
                System.out.println("Status update: " + status_update);
                System.out.println("Date record: " + date_record);
                System.out.println("Member ID: " + member_id);
                System.out.println();


            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void processPayment(int payment_id){
        try {
            String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "UPDATE payment SET status_update = 'payment processed' WHERE payment_id = " + payment_id;


            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }



    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Health and Fitness Club Management System";
        String user = "postgres";
        String password = "Alpha2022";

        try {
            Class.forName("org.postgresql.Driver");
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to PostgreSQL successfully!");
                System.out.println("");
            } else {
                System.out.println("Failed to establish connection.");
            }
            conn.close();
        }
        //Error handling to check for any exceptions
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        Main database = new Main();


        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Performance Fitness Club! ");
        System.out.println();
        int typeOfUser;


        do {
            typeOfUser = database.typeofUser();

            switch (typeOfUser) {
                case 1:
                    System.out.println();
                    System.out.println("Welcome to Member functions! Please enter the corresponding number for what you would like to do?");
                    System.out.println();
                    int functionNumber;


                    do {
                        functionNumber = database.memberTypeOfUser();

                        switch (functionNumber) {
                            case 1:
                                System.out.println();
                                System.out.print("Please enter your first name: ");
                                String first_nameMember = scanner.next();
                                System.out.print("Please enter your last name: ");
                                String last_nameMember = scanner.next();
                                System.out.print("Please enter your weight goal in kg: ");
                                int weightGoal = scanner.nextInt();
                                System.out.print("Please enter your time goal in seconds: ");
                                int timeGoal = scanner.nextInt();
                                System.out.print("Please enter your resting heart rate: ");
                                int restingHeartRate = scanner.nextInt();
                                System.out.print("Please enter your BMI: ");
                                double bmi = scanner.nextDouble();
                                System.out.println();
                                database.addMember(first_nameMember, last_nameMember, weightGoal, timeGoal, restingHeartRate, bmi);

                                System.out.println("The member has successfully joined! Now please schedule a training session from the options below.");
                                System.out.println();
                                database.getTrainingSession();
                                System.out.print("Enter the corresponding session id to schedule your training session: ");
                                int sessionId = scanner.nextInt();
                                int memberID = database.getMemberId(first_nameMember, last_nameMember);
                                database.updateTrainingSession(memberID,sessionId);

                                System.out.println("The new member registration fee is $100.00");
                                System.out.print("Please enter 1 if you would like to make the payment now or 2 if you want to postpone: ");
                                int payment = scanner.nextInt();

                                if (payment == 1){
                                    database.addPayment(100.00, "Paid", "2024-04-10", String.valueOf(memberID));
                                    System.out.println("The transaction has been confirmed!");
                                    System.out.println();
                                }
                                else{
                                    database.addPayment(100.00, "Pending", "2024-04-10", String.valueOf(memberID));
                                    System.out.println();
                                }
                                database.addDashboard(memberID, restingHeartRate, bmi);
                                break;

                            case 2:
                                System.out.print("What is your first name: ");
                                String firstNameCase2 = scanner.next();
                                System.out.print("What is your last name: ");
                                String lastNameCase2 = scanner.next();
                                int memberIDCase2 = database.getMemberId(firstNameCase2, lastNameCase2);
                                System.out.print("What is your new weight goal in kg: ");
                                int newWeightGoal = scanner.nextInt();
                                System.out.print("What is your new time goal in seconds: ");
                                int newTimeGoal = scanner.nextInt();
                                System.out.print("What is your new resting heart rate: ");
                                int newRestingHeartRate = scanner.nextInt();
                                System.out.print("What is your new BMI: ");
                                double newBmi = scanner.nextDouble();

                                database.updateMemberProfile(memberIDCase2, newWeightGoal, newTimeGoal, newRestingHeartRate, newBmi);
                                System.out.println();
                                System.out.println("Your profile has been updated successfully!");
                                System.out.println();
                                break;

                            case 3:
                                System.out.print("What is your first name: ");
                                String firstNameCase3 = scanner.next();
                                System.out.print("What is your last name: ");
                                String lastNameCase3 = scanner.next();
                                int memberIDCase3 = database.getMemberId(firstNameCase3, lastNameCase3);
                                System.out.println();
                                System.out.println("Your Personalized Dashboard!");
                                database.getDashboard(memberIDCase3);
                                System.out.println();
                                break;

                            case 4:
                                System.out.print("What is your first name: ");
                                String firstNameCase4 = scanner.next();
                                System.out.print("What is your last name: ");
                                String lastNameCase4 = scanner.next();
                                int memberIDCase4 = database.getMemberId(firstNameCase4, lastNameCase4);
                                System.out.println();
                                System.out.print("Please enter 1 if you would like to schedule a training session, 2 if you would like to reschedule a training session, 3 if you would like to cancel a training session: ");
                                int option = scanner.nextInt();

                                if (option == 1){
                                    database.getTrainingSession();
                                    System.out.print("Enter the corresponding session id to schedule the training session: ");
                                    int sessionIdCase4 = scanner.nextInt();
                                    database.updateTrainingSession(memberIDCase4,sessionIdCase4);
                                }
                                else if (option == 2){
                                    database.getTrainingSession();
                                    System.out.print("Enter the corresponding session id to reschedule the training session: ");
                                    int sessionIdCase5 = scanner.nextInt();
                                    database.removeTrainingSession(memberIDCase4);
                                    database.updateTrainingSession(memberIDCase4,sessionIdCase5);
                                }
                                else{
                                    System.out.println();
                                    database.removeTrainingSession(memberIDCase4);
                                    System.out.println("Your training session has been cancelled!");
                                    System.out.println();
                                }
                                break;

                            case 5:
                                break;
                        }
                    } while (functionNumber != 5);
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Welcome to Trainer functions! Please enter the corresponding number for what you would like to do?");
                    System.out.println();
                    int functionTrainerNumber;


                    do {
                        functionTrainerNumber = database.trainerTypeOfUser();

                        switch (functionTrainerNumber) {
                            case 1:
                                System.out.println();
                                System.out.println("Let's set the time for when you are available!");
                                System.out.println();

                                System.out.print("Please enter your first name: ");
                                String firstNameTrainer = scanner.next();
                                System.out.print("Please enter your last name: ");
                                String lastNameTrainer = scanner.next();

                                int trainerID = database.getTrainerId(firstNameTrainer, lastNameTrainer);

                                System.out.print("Please enter if it is a personal or group session: ");
                                String typePG = scanner.next();
                                System.out.print("Please enter the time slot for which you are available: ");
                                String timeSlot = scanner.next();

                                database.addTrainingSession(typePG, timeSlot, trainerID);
                                break;

                            case 2:
                                System.out.print("Please enter the first name of the member you want to see the profile for: ");
                                String firstNameMember = scanner.next();
                                System.out.print("Please enter the last name of the member you want to see the profile for: ");
                                String lastNameMember = scanner.next();
                                database.getMemberProfile(firstNameMember, lastNameMember);
                                break;

                            case 3:
                                break;
                        }
                    } while (functionTrainerNumber != 3);
                    break;

                case 3:
                    System.out.println();
                    System.out.println("Welcome to Administrative Staff functions! Please enter the corresponding number for what you would like to do?");
                    System.out.println();
                    int functionAdminNumber;


                    do {
                        functionAdminNumber = database.adminTypeOfUser();

                        switch (functionAdminNumber) {
                            case 1:
                                System.out.println();
                                System.out.print("What is the name of the room you would like to manage: ");
                                String nameOfRoom = scanner.next();
                                System.out.print("What is the status of the room: ");
                                String status = scanner.next();
                                System.out.print("What is the capacity of the room: ");
                                int capacity = scanner.nextInt();
                                database.manageRoom(nameOfRoom, status, capacity);
                                System.out.println();
                                break;

                            case 2:
                                System.out.println();
                                System.out.print("What is the name of the equipment you would like to manage: ");
                                String nameOfEquipment = scanner.next();
                                System.out.print("What is the status of the room: ");
                                String statusUpdate = scanner.next();
                                System.out.print("What is the last maintenance date for this equipment: ");
                                String lastMaintenanceDate = scanner.next();
                                database.manageEquipment(nameOfEquipment, statusUpdate, lastMaintenanceDate);
                                System.out.println();
                                break;

                            case 3:
                                System.out.println();
                                System.out.print("What is the session id of the class you want to update: ");
                                int sessionIdAdmin = scanner.nextInt();
                                System.out.print("What is the type of the class (personal or group) : ");
                                String typeOfClass = scanner.next();
                                System.out.print("What is the time slot for the class you want to update: ");
                                String timeSlotAdmin = scanner.next();
                                database.updateAdminTrainingSession(sessionIdAdmin, typeOfClass, timeSlotAdmin);
                                System.out.println();
                                break;

                            case 4:
                                System.out.println("All the payment data below");
                                System.out.println();
                                database.getPaymentData();
                                System.out.println();
                                System.out.print("For what payment id would you like to process the payment for: ");
                                int paymentIDAdmin = scanner.nextInt();
                                database.processPayment(paymentIDAdmin);
                                System.out.println("Payment processed!");
                                System.out.println();
                                break;

                            case 5:
                                break;
                        }
                    } while (functionAdminNumber != 5);
                    break;


                case 4:
                    System.out.println("Exiting Performance Fitness Club.");
                    break;
            }
        } while (typeOfUser != 4);
    }
}
