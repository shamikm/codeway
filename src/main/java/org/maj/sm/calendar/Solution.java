package org.maj.sm.calendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shamik.majumdar
 */
public class Solution {
    private static final Map<String,Integer> MONTH_MAP = new HashMap<>();
    private static final Map<String,Integer> MONTH_NUM_DAY_MAP = new HashMap<>();
    static {
        MONTH_MAP.put("January",1);
        MONTH_MAP.put("February",2);
        MONTH_MAP.put("March",3);
        MONTH_MAP.put("April",4);
        MONTH_MAP.put("May",5);
        MONTH_MAP.put("June",6);
        MONTH_MAP.put("July",7);
        MONTH_MAP.put("August",8);
        MONTH_MAP.put("September",9);
        MONTH_MAP.put("October",10);
        MONTH_MAP.put("November",11);
        MONTH_MAP.put("December",12);
    }
    static {
        MONTH_NUM_DAY_MAP.put("January",31);
        MONTH_NUM_DAY_MAP.put("February",28);
        MONTH_NUM_DAY_MAP.put("March",31);
        MONTH_NUM_DAY_MAP.put("April",30);
        MONTH_NUM_DAY_MAP.put("May",31);
        MONTH_NUM_DAY_MAP.put("June",30);
        MONTH_NUM_DAY_MAP.put("July",31);
        MONTH_NUM_DAY_MAP.put("August",31);
        MONTH_NUM_DAY_MAP.put("September",30);
        MONTH_NUM_DAY_MAP.put("October",31);
        MONTH_NUM_DAY_MAP.put("November",30);
        MONTH_NUM_DAY_MAP.put("December",31);
    }
    public LocalDate getNextPrioidStart(LocalDate d){
        if (d.getDayOfWeek().ordinal() == 0) {
            return  d;
        }
        return d.plusDays(7 - d.getDayOfWeek().ordinal());
    }
    public LocalDate getLastPrioidStart(LocalDate d){
        if (d.getDayOfWeek().ordinal() == 0) {
            return  d;
        }
        return d.minusDays(d.getDayOfWeek().ordinal());
    }
    public int solution(int Y, String A, String B, String W) {
        // write your code in Java SE 8
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start = LocalDate.parse(String.format("01/%02d/%4d",MONTH_MAP.get(A),Y),dateTimeFormatter);
        LocalDate end = LocalDate.parse(String.format("%02d/%02d/%4d",MONTH_NUM_DAY_MAP.get(B),MONTH_MAP.get(B),Y),dateTimeFormatter);
        start = getNextPrioidStart(start);
        end = getLastPrioidStart(end);
        return (int) (start.until(end, ChronoUnit.DAYS)/7);

    }

    public static void main(String... args){
        Solution solution = new Solution();
        System.out.println(solution.solution(2014,"April","May",""));
    }
}
