package org.maj.sm.phonebill;

import java.util.*;

/**
 *  00:01:07,400-234-090
    00:05:01,701-080-080
    00:05:00,400-234-090
 * @author shamik.majumdar
 */
public class Solution {
    class PhoneLog implements Comparable<PhoneLog>{
        private int duration;
        private final String phoneNum;

        public PhoneLog(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        public void addDuration(int duration){
            this.duration += duration;
        }

        public int getDuration() {
            return duration;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        /**
         * If duration is same we sort by phone num
         * @param o
         * @return
         */
        @Override
        public int compareTo(PhoneLog o) {
            int res = duration > o.duration ? -1 : duration < o.duration ? 1 : 0;
            if (res == 0){
                res = this.phoneNum.compareTo(o.phoneNum);
            }
            return res;
        }
    }
    public int solution(String S) {
        // write your code in Java SE 8
        if (S == null  || S.isEmpty()) return 0;
        int bill = 0;
        Map<String,PhoneLog> phoneMap = new HashMap<>();

        String[] logs = S.split("\n");
        List<PhoneLog> phoneLogList = new ArrayList<>();
        for (String log : logs){
            String[] tokens = log.trim().split(",");
            if (tokens.length == 2) {
                String phoneNum = tokens[1];
                String[] dString = tokens[0].split(":");
                int duration = 0;
                if (dString.length == 3) {
                    duration = Integer.parseInt(dString[0]) * 60 * 60 +
                            Integer.parseInt(dString[1]) * 60  +
                            Integer.parseInt(dString[2]);
                }
                PhoneLog phoneLog = phoneMap.get(phoneNum); // get the phone num
                if (phoneLog == null) {
                    phoneLog = new PhoneLog(phoneNum);
                    phoneMap.put(phoneNum,phoneLog);
                    phoneLogList.add(phoneLog);
                }
                phoneLog.addDuration(duration);
            }
        }
        //Sort them up
        Collections.sort(phoneLogList);
        //ignore the first one - Rule 3
        if (phoneLogList.size() > 1) {
            for (int i = 1; i < phoneLogList.size(); i++) {
                PhoneLog phoneLog = phoneLogList.get(i);
                // Rule 1  - duration less than 5 min - 300 sec
                if (phoneLog.duration < 300) {
                    bill = bill + phoneLog.duration * 3 ;
                }else {
                    //Rule 2 - pay the bill by each minute
                    bill = bill + ((phoneLog.duration/60) + (phoneLog.duration%60 == 0 ? 0 : 1)) * 150;
                }
            }
        }
        return bill;
    }

    public static void main(String... args){
        Solution s = new Solution();
        int b = s.solution(
                "   00:01:07,400-234-090\n" +
                "   00:05:01,701-080-080\n" +
                "   00:05:00,400-234-090"
        );

        System.out.println(b);
    }
}
