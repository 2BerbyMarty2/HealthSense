public class Main {

    public static void main(String[] args) {

        while (true) {
            // Print main menu header
            System.out.println();


            int setting = Menu.menu();

            switch (setting) {
                case 1:
                    System.out.println();
                    System.out.println("------------------------Add a Hospital----------------------------------------");
                    InputManager.hospitalInput();
                    break;

                case 2:
                    System.out.println();

                    int SettingThree = Menu.RemovedMenu();
                    switch (SettingThree) {
                        case 1:
                            InputManager.hospitalList.undoRemove();
                            break;
                        case 2:
                            System.out.println("----------------------Remove a Hospital-------------------------------------");
                            InputManager.removeHospital();
                            break;
                        default:
                            break;
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.println("---------------------List Hospitals---------------------------------------");
                    InputManager.hospitalList.displayHospitalNames();
                    break;

                case 4:
                    System.out.println();
                    System.out.println("---------------------Hospital Insights--------------------------------------");
                    System.out.println();
                    int SecondSetting = Menu.analysisMenu();
                    switch (SecondSetting) {
                        case 1:
                            AnalysisManager.analysisByDisease();
                            break;

                        // To do view disease summary
                        case 2:
                            AnalysisManager.sortBySeverity();
                            break;
                        // To do sort by severity
                        case 3:
                            // To do weekly trends
                            AnalysisManager.weeklyTrends();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid option. Please select 1–4.\n");
                    }
                    break;

                case 5:
                    System.out.println();
                    int SettingFour = Menu.searchMenu();
                    switch (SettingFour) {
                        case 1:
                            System.out.println("--------------- Search by Hospital Name ----------------");
                            System.out.println();

                            String name = "";
                            while (name.isEmpty()) {
                                System.out.print("Enter hospital name: ");
                                name = InputManager.scanner.nextLine().trim();
                                if (name.isEmpty()) {
                                    System.out.println("Name cannot be empty. Please try again.");
                                }
                            }

                            boolean found = InputManager.hospitalList.searchHospitalByName(name);
                            if (!found) {
                                System.out.println("Try again or check the spelling.");
                            }
                            System.out.println("--------------------------------------------------------");
                            break;
                        case 2:
                            System.out.println("--------------- Search by Disease Name ----------------");
                            System.out.println();

                            String diseaseName = "";
                            while (diseaseName.isEmpty()) {
                                System.out.print("Enter disease name: ");
                                diseaseName = InputManager.scanner.nextLine().trim();
                                if (diseaseName.isEmpty()) {
                                    System.out.println("Disease name cannot be empty. Please try again.");
                                }
                            }

                            DiseaseList allDiseases = InputManager.hospitalList.getAllDisease();
                            allDiseases.search(diseaseName);  // Search using disease name

                            break;
                        default:
                            break;
                    }
                    break;

                case 6:
                    System.out.println();
                    System.out.println("---------------------Outbreak Reports--------------------------------------");
                    int SettingFive = Menu.OutbreakReportsMenu();
                    switch (SettingFive) {
                        case 1:
                            OutbreakManager.nextOutbreakReport();
                            break;
                        case 2:
                            OutbreakManager.addOutbreakReport();
                            break;
                        default:
                            break;
                    }
                    break;



                case 7:
                    System.out.println("\nExiting... Goodbye!");
                    System.exit(0);
                default:
                    break;
            }
            }

        }

}// end of class