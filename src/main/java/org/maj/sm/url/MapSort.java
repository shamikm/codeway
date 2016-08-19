package org.maj.sm.url;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Given a file (which can be considered as a String with comma delimiter for the complexity of the question) of \
 * usernames and a value k, find top k usernames (with number of logins) who logged into the system the most.
 * For example -
 * Input:
 * User (String) =  user1, user4, user2, user1, user3, user1, user2, user3
 * k (int) = 2
 *
 * Output:
 * user1 (3)
 * user2 (2)
 * user3 (2)
 * - Both user2 and user3 should be included since both has same number of logins
 * Write a java method to find the output with best time and space complexity.
 *
 * @author shamik.majumdar
 *
 */
public class MapSort {
    private static class UserEntry implements Comparable<UserEntry> {
        private final String user;
        private int numOfLogIn;

        public UserEntry(String user, int numOfLogIn) {
            this.user = user;
            this.numOfLogIn = numOfLogIn;
        }

        public UserEntry(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public int getNumOfLogIn() {
            return numOfLogIn;
        }

        public void setNumOfLogIn(int numOfLogIn) {
            this.numOfLogIn = numOfLogIn;
        }

        /**
         * This does invalidates the equals constraints.
         * a.equals(b) is not a.compareTo(b) in this case
         * @param o
         * @return
         */

        @Override
        public int compareTo(UserEntry o) {
            //return 0 will merge the keys - so avoid returning 0
            //return numOfLogIn < o.numOfLogIn ? -1 : numOfLogIn > o.numOfLogIn ? 1 : -1;
            return numOfLogIn < o.numOfLogIn ? 1 : -1;
        }

        @Override
        public String toString() {
            return "UserEntry{" +
                    "user='" + user + '\'' +
                    ", numOfLogIn=" + numOfLogIn +
                    '}';
        }
    }

    /**
     * Algorithm is to try to put the UserEntries in a tree so that they are always sorted.
     * @param users
     * @param num
     * @return
     */
    public Collection<UserEntry> sortUserEntries(String users, int num){
        String[] usersArray = users.split(",");
        Map<String,UserEntry> map = new HashMap<>();
        TreeSet<UserEntry> sortedSet = new TreeSet<>();

        for (String u : usersArray){
            u = u.trim();
            UserEntry userEntry = map.get(u);
            if (userEntry == null){
                UserEntry ue = new UserEntry(u,1);
                map.put(u,ue);
                sortedSet.add(ue);
            }else {
                //remove from the set
                sortedSet.remove(userEntry);
                //edit it
                userEntry.setNumOfLogIn(userEntry.getNumOfLogIn()+1);
                //add it back to the set
                sortedSet.add(userEntry);
            }
        }

        return sortedSet.headSet(new UserEntry("",num),true);
    }

    public static void main(String... args){
        UserEntry ue1 = new UserEntry("shamik",3);
        UserEntry ue2 = new UserEntry("payal",4);
        List<UserEntry> userEntries = Lists.newArrayList(ue1,ue2);
        Collections.sort(userEntries);
        System.out.println(userEntries);

    }
}
