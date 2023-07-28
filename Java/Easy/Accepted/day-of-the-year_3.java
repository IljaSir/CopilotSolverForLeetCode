class Solution {
    public int dayOfYear(String date) {
        
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += days[i];
        }
        if (month > 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            res += 1;
        }
        return res + day;
    }
}