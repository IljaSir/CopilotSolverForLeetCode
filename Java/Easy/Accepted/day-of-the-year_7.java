class Solution {
    public int dayOfYear(String date) {
        
        int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dates = date.split("-");
        int y = Integer.parseInt(dates[0]);
        int m = Integer.parseInt(dates[1]);
        int d = Integer.parseInt(dates[2]);
        int day = 0;
        for (int i = 0; i < m - 1; i++) {
            day += days[i];
        }
        day += d;
        if (m > 2 && (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)) {
            day += 1;
        }
        return day;
    }
}