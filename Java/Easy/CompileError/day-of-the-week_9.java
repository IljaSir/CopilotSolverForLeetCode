class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        int[] m = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] w = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int days = 0;
        for(int i = 1971; i < year; i++) {
            days += isLeap(i) ? 366 : 365;
        }
        for(int i = 1; i < month; i++) {
            days += m[i];
            if(i == 2 && isLeap(year)) {
                days++;
            }
        }
        days += day;
        return w[days % 7];
    }
}