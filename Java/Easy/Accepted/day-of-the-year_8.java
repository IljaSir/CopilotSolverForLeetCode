class Solution {
    public int dayOfYear(String date) {
        
        String[] dt = date.split("-");
        int year = Integer.parseInt(dt[0]);
        int month = Integer.parseInt(dt[1]);
        int day = Integer.parseInt(dt[2]);
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += days[i];
        }
        res += day;
        if (month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            res += 1;
        }
        return res;
    }
}