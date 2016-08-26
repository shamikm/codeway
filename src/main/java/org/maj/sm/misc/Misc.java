package org.maj.sm.misc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author shamik.majumdar
 */
public class Misc {

    /**
     * If you have a task that you need to complete on a regular basis, you can set it up in
     * Asana as a recurring task. One option is to schedule the task to repeat every k weeks on
     * specified days of the week.
     * It would be useful to be able to view the first n dates for which the task is scheduled.
     * Given the first date for which the task is scheduled, return an array of the first n dates.
     * In this task, you'll likely need month lengths and weekday names, provided here:
     * Month lengths from January to December: 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31.
     * During leap years February has 29 days.
     * Names of weekdays: "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday".
     * January 1, 2015 was a Thursday.
     * Example
     * For firstDate = "01/01/2015", k = 2, daysOfTheWeek = ["Monday", "Thursday"] and n = 4, the output should be
     * recurringTask(firstDate, k, daysOfTheWeek, n) =["01/01/2015", "05/01/2015", "15/01/2015", "19/01/2015"]

     *
     */
    public static String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
        List<String> results = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(firstDate,dateTimeFormatter);
        date.getDayOfWeek().name();
        Set<String> dayOfWeekSet = new HashSet<>();
        for (String s : daysOfTheWeek){
            dayOfWeekSet.add(s.toUpperCase());
        }

        int multiplier = 0;
        while (n > 0 ){
            date = date.plusWeeks(multiplier*k);
            multiplier++;

            for (int i=0; i < 7; i++) {
                LocalDate t = date.plusDays(i);
                if (dayOfWeekSet.contains(t.getDayOfWeek().name())){
                    results.add(t.format(dateTimeFormatter));
                    n--;
                }
            }

        }

        return results.toArray(new String[0]);
    }

    /**
     * This is to make sure deadl
     * @param deadlines
     * @param day
     * @return
     */
    public static int[] tasksTypes(int[] deadlines, int day) {
        int[] result = new int[3];
        for (int i = 0; i < deadlines.length; i++) {
            if ((deadlines[i] >= (day + 1)) && (deadlines[i] <= (day + 7))) {
                result[1] = result[1] + 1;
            }else if (deadlines[i] <= day) {
                result[0] = result[0] + 1;
            } else {
                result[2] = result[2] + 1;
            }
        }
        return result;
    }

    /**
     * From codefight.com
     *
     * This is to make sure you assign a task to someone who has least tasks
     *
     * @param information
     * @return
     */
    public static String smartAssigning(String[][] information) {
        class User implements Comparable<User> {
            private final String name;
            private final int status;
            private final int projects;
            private final int tasks;

            public User(String name, int status, int projects, int tasks) {
                this.name = name;
                this.status = status;
                this.projects = projects;
                this.tasks = tasks;
            }

            public String getName() {
                return name;
            }

            public int getStatus() {
                return status;
            }

            public int getProjects() {
                return projects;
            }

            public int getTasks() {
                return tasks;
            }

            @Override
            public int compareTo(User o) {
                int res = tasks < o.tasks ? -1 : tasks == o.tasks ? 0 : 1;
                if (res == 0){
                    res = projects < o.projects ? -1 : projects == o.projects ? 0 : 1;
                }
                return res;
            }
        }
        List<User> users = new ArrayList<>();
        for (int i=0; i < information.length; i++){
            User user = new User(information[i][0],Integer.valueOf(information[i][1]),
                    Integer.valueOf(information[i][2]),Integer.valueOf(information[i][3]));

            users.add(user);
        }

        Collections.sort(users);

        for (User u : users){
            if (u.getStatus() != 0){
                return u.getName();
            }
        }
        return null;

    }


    static int[] reverse(int[] validData ){
        for(int i = 0; i < validData.length / 2; i++)
        {
            int temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
        return validData;
    }

    public static int[] incrementalBackups(int lastBackupTime, int[][] changes) {

        class MyFile implements Comparable<MyFile>{
            private final int id;
            private final int lastChange;

            public MyFile(int id, int lastChange) {
                this.id = id;
                this.lastChange = lastChange;
            }

            public int getId() {
                return id;
            }

            public int getLastChange() {
                return lastChange;
            }

            @Override
            public int compareTo(MyFile o) {
                return lastChange < o.lastChange ? -1 : lastChange > o.lastChange ? 1 : 20;
            }
        }
        Map<Integer,MyFile> fileMap = new HashMap<>();


        for (int i=0; i < changes.length ; i++){
            int id = changes[i][1];
            MyFile myFile = fileMap.get(id);
            if (myFile == null){
                myFile = new MyFile(id,changes[i][0]);
                fileMap.put(changes[i][1],myFile);
            }
            else {
                if (changes[i][0] > myFile.lastChange) {
                    myFile = new MyFile(changes[i][1],changes[i][0]);
                    fileMap.put(changes[i][1],myFile);
                }
            }
        }

        TreeSet<MyFile> myFiles = new TreeSet<>(fileMap.values());
        Set<MyFile> files = myFiles.tailSet(new MyFile(-1,lastBackupTime),false);
        int[] results = new int[files.size()];
        int index = 0;
        for (MyFile f : files) {
            results[index++] = f.getId();
        }
        Arrays.sort(results);
        return results;
    }

    /**
     * sorted array = 1,2,5,5,7,60
     */
    public static void sort(){
        int[] arr = new int[]{5,1,7,60,2,5};
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr,8);
        if (index < 0 ){
            index = -(index+1);
        }
        System.out.println(index);

    }


    /**
     * UBER
     * @param
     */

    double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
        double[] fares = new double[cost_per_minute.length];
        for (int i=0; i < cost_per_minute.length;i++){
            fares[i] = ride_time * cost_per_minute[i] + ride_distance * cost_per_mile[i];
        }
        return fares;
    }

    /**
     * For departure = [0.4, 1] and destination = [0.9, 3], the output should be
     perfectCity(departure, destination) = 2.7.

     0.6 + 2 + 0.1 = 2.7, which is the answer.
     * @param departure
     * @param destination
     * @return
     */
    /*static double perfectCity(double[] departure, double[] destination) {
        double distance;
        if (departure[0] == destination[0] || departure[1] == destination[1]){
            distance = Math.abs(departure[0]-destination[0]) + (Math.abs(destination[1] - departure[1]));
        }
        else if (Math.ceil(departure[0]) == Math.ceil(destination[0])) {
            if (departure[0] > destination[0]) {
                distance = departure[0] + (Math.abs(destination[1] - departure[1])) + destination[0];
            } else {
                distance = (Math.ceil(departure[0]) - departure[0]) + (Math.abs(destination[1] - departure[1])) + (Math.ceil(destination[0]) - destination[0]);
            }
        }else if (Math.ceil(departure[1]) == Math.ceil(destination[1])){
            if (departure[1] < destination[1]) {
                distance = departure[1] + (Math.abs(destination[0] - departure[0])) + destination[1];
            } else {
                distance = (Math.ceil(departure[1]) - departure[1]) + (Math.abs(destination[0] - departure[0])) + (Math.ceil(destination[1]) - destination[1]);
            }
        } else{
            distance = Math.abs(departure[0]-destination[0]) + (Math.abs(destination[1] - departure[1]));
        }
        return distance;
    }*/


    static double perfectCityV2(double[] departure, double[] destination) {
        double distance;
        if (departure[0] == destination[0] || departure[1] == destination[1]){
            distance = Math.abs(departure[0]-destination[0]) + (Math.abs(destination[1] - departure[1]));
        }
        //if within x axis
        else if (departure[0] != destination[0] && Math.ceil(departure[0]) == Math.ceil(destination[0])) {
            /*if (departure[0] > destination[0]) {
                distance = departure[0] + (Math.abs(destination[1] - departure[1])) + destination[0];
            } else {
                distance = (Math.ceil(departure[0]) - departure[0]) + (Math.abs(destination[1] - departure[1])) + (Math.ceil(destination[0]) - destination[0]);
            }*/
            distance = Math.min(departure[0]+destination[0], (Math.ceil(departure[0]) - departure[0]) + (Math.ceil(destination[0]) - destination[0])) + Math.abs(destination[1] - departure[1]);
        }else if (departure[1] != destination[1] && Math.ceil(departure[1]) == Math.ceil(destination[1])){
            /*if (departure[1] < destination[1]) {
                distance = departure[1] + (Math.abs(destination[0] - departure[0])) + destination[1];
            } else {
                distance = (Math.ceil(departure[1]) - departure[1]) + (Math.abs(destination[0] - departure[0])) + (Math.ceil(destination[1]) - destination[1]);
            }*/
            distance = Math.min(departure[1]+destination[1], (Math.ceil(departure[1]) - departure[1]) + (Math.ceil(destination[1]) - destination[1])) + Math.abs(destination[0] - departure[0]);
        } else{
            distance = Math.abs(departure[0]-destination[0]) + (Math.abs(destination[1] - departure[1]));
        }
        return distance;
    }

    static boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        //case 1, make sure lucky spot is not occupied
        boolean result = true;
        for (int i=luckySpot[0]; i < luckySpot[2]; i++){
            for (int j=luckySpot[1]; j< luckySpot[3]; j++){
                if (parkingLot[i][j] == 1) {
                    result = false;
                    break;
                }
            }
        }

        if (result){
            //case 2, check surrounding
            boolean free = false;

            //check front
            for (int i=luckySpot[0]; i < luckySpot[2]; i++){
                for (int j=0;j<luckySpot[1];j++){
                    if (parkingLot[i][j] == 1){
                        free = free || true;
                        break;
                    }
                }
            }
            //check back
            for (int i=luckySpot[0]; i < luckySpot[2]; i++){
                for (int j=luckySpot[3];j<parkingLot[i].length;j++){
                    if (parkingLot[i][j] == 1){
                        free = free || true;
                        break;
                    }
                }
            }

            //Check up
            for (int i=0; i < luckySpot[0]; i++){
                for (int j=luckySpot[1];j<luckySpot[3];j++){
                    if (parkingLot[i][j] == 1){
                        free = free || true;
                        break;
                    }
                }
            }
            //check down
            for (int i=luckySpot[2]; i < parkingLot.length; i++){
                for (int j=luckySpot[1];j<luckySpot[3];j++){
                    if (parkingLot[i][j] == 1){
                        free = free || true;
                        break;
                    }
                }
            }

            result = free;
        }


        return result;
    }

    public static void maxMatch(String s1, String s2){
        int remIndex = -1;
        int lenthg = -1;
        for (int i=0; i<s2.length(); i++){
            int index = s1.indexOf(s2.substring(0,i+1));
            if (index != -1 ) {

            }
        }

    }

    /**
     *
     * For inputString = "a bacabad abacab a" and width = 7, the output should be
     * losslessDataCompression(inputString, width) = "ab(0,1)c(0,3)d(4,3)c(8,3)".
     * @param inputString
     * @param width
     * @return
     */

    static String losslessDataCompression(String inputString, int width) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i < inputString.length(); i++){
            char ch = inputString.charAt(i);
            String origStr = getSubstring(inputString,i,width);
            int length = 0;
            int matchingIndex = -1;
            for (int j=0 ; j < origStr.length() ; j++){
                if (ch == origStr.charAt(j)) {
                    if (matchingIndex < 0) matchingIndex = j;
                    length++;
                    ch = inputString.charAt(Math.min(i+length,inputString.length()-1));
                }else {
                    //matchingIndex = -1;
                    ch=inputString.charAt(i);
                }
            }
            if (length == 0) {
                result.append(ch);
            }else {
                i = i + length -1;
                result.append(String.format("(%d,%d)",i<width ? 0+matchingIndex : i-width + matchingIndex,length));
            }

        }

        return  result.toString();

    }

    private static String getSubstring(String str, int i, int width) {
        int startIndex = i < width ? 0 : (i-width);
        return str.substring(startIndex,i);
    }


    boolean incorrectPasscodeAttempts(String passcode, String[] attempts) {
        int count = 0;
        for (int i=0;i<attempts.length;i++){
            if (passcode.equals(attempts[i])) {
                count = 0;
            }else {
                count++;
            }
            if (count >= 10){
                return true;
            }
        }
        return false;
    }

    public static  void main(String... args){
        //System.out.println(tasksTypes(new int[]{8},1));
        //recurringTask("01/01/2015",2,new String[]{"Monday"},2);
        /*for (String s : recurringTask("01/01/2015",2,new String[]{"Monday","Thursday"},4)){
            System.out.println(s);
        }*/

        /*int[] results = incrementalBackups(461620205 ,new int[][]{
                {461620203, 1},
                {461620204, 2},
                {461620205, 6},
                {461620206, 5},
                {461620207, 3},
                {461620207, 5},
                {461620208, 1}});
        for (int i=0; i < results.length ; i++){
            System.out.println(results[i]);
        }*/
        //sort();
        /*System.out.println(Math.ceil(0.2));
        System.out.println(Math.ceil(0.6));*/

        //System.out.println(perfectCityV2(new double[]{0.4,1},new double[]{0.9,3}));
        System.out.println(losslessDataCompression("abacabadabacaba",7));
    }

}
