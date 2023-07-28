class Solution {
    public int dayOfYear(String date) {
        
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dateArr = date.split("-");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        int count = 0;
        for (int i = 0; i < month - 1; i++) {
            count += days[i];
        }
        count += day;
        if (month > 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            count += 1;
        }
        return count;
    }
}