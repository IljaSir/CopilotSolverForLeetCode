class Solution {
    public int dayOfYear(String date) {
        
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int sum = 0;
        for(int i = 0; i < month - 1; i++){
            sum += days[i];
        }
        sum += day;
        if(month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
            sum += 1;
        }
        return sum;
    }
}