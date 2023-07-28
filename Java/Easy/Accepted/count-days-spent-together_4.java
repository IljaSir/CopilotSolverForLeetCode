class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int days = 0;
        int start = Math.max(getDays(arriveAlice), getDays(arriveBob));
        int end = Math.min(getDays(leaveAlice), getDays(leaveBob));
        for (int i = start; i <= end; i++) {
            days++;
        }
        return days;
    }
    private int getDays(String date) {
        String[] arr = date.split("-");
        int month = Integer.parseInt(arr[0]);
        int day = Integer.parseInt(arr[1]);
        int days = 0;
        for (int i = 1; i < month; i++) {
            days += getDaysOfMonth(i);
        }
        days += day;
        return days;
    }
    private int getDaysOfMonth(int month) {
        if (month == 2) {
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }
}