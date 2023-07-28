class Solution {
    public int dayOfYear(String date) {
        
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);

        int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            daysPerMonth[1] = 29;
        }

        int days = 0;
        for (int i = 0; i < month - 1; i++) {
            days += daysPerMonth[i];
        }
        days += day;
        return days;
    }
}