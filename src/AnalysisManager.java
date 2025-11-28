public class AnalysisManager {

    // I have to analyze data by the disease name
    // each unique name will be a new node in the list
    //
    static void analysisByDisease () {
        InputManager.hospitalList.getAllDisease().displayList();
        InputManager.hospitalList.getAllDisease().totalNumberOfCases();
    }
    static void sortBySeverity () {
        InputManager.hospitalList.getAllDisease().BSTTraversal();
        // Sort by severity

        // View disease summary, sort by severity, weekly trends, back
    }
    static void weeklyTrends(){
        InputManager.hospitalList.getAllDisease().printAggregatedWeeklyCases();
        // This function will give all weeks weekly trends
        // Like what is the most cases in week 1, week 2, week 3, etc.
        // This will be done by comparing the cases in each week
    }


}
