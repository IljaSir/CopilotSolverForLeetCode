class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        String[] date1 = arriveAlice.split("-");
        String[] date2 = leaveAlice.split("-");
        String[] date3 = arriveBob.split("-");
        String[] date4 = leaveBob.split("-");
        int[] day1 = new int[2];
        int[] day2 = new int[2];
        int[] day3 = new int[2];
        int[] day4 = new int[2];
        for (int i = 0; i < 2; i++) {
            day1[i] = Integer.parseInt(date1[i]);
            day2[i] = Integer.parseInt(date2[i]);
            day3[i] = Integer.parseInt(date3[i]);
            day4[i] = Integer.parseInt(date4[i]);
        }
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        for (int i = day1[0]; i <= day2[0]; i++) {
            if (i == day1[0] && i == day2[0]) {
                count += Math.min(day2[1], day4[1]) - Math.max(day1[1], day3[1]) + 1;
            } else if (i == day1[0]) {
                count += Math.min(daysInMonth[i - 1] - day1[1] + 1, day4[1]);
            } else if (i == day2[0]) {
                count += Math.min(day2[1], day4[1]);
            } else {
                count += Math.min(daysInMonth[i - 1], day4[1]);
            }
        }
        return count;
    }
}