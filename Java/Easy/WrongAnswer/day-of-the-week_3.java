class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        int totalDays = 0;
        for(int i=1971; i<year; i++){
            totalDays += 365;
            if(i%4==0 && i%100 != 0 || i%400==0){
                totalDays++;
            }
        }
        for(int i=0; i<month-1; i++){
            totalDays += monthDays[i];
            if(i==1 && year%4==0 && year%100 != 0 || year%400==0){
                totalDays++;
            }
        }
        totalDays += day;
        return days[totalDays%7];
    }
}