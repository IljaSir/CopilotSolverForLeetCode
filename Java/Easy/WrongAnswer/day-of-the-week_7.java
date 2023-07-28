class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int daysFrom1971 = 0;
        for(int i = 1971; i < year; i++){
            if(isLeapYear(i)){
                daysFrom1971 += 366;
            }else{
                daysFrom1971 += 365;
            }
        }
        for(int i = 0; i < month - 1; i++){
            if(isLeapYear(year) && i == 1){
                daysFrom1971 += 1;
            }
            daysFrom1971 += daysOfMonth[i];
        }
        daysFrom1971 += day - 1;
        return days[daysFrom1971 % 7];
    }
    public boolean isLeapYear(int year){
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
}