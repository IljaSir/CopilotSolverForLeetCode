class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;
        for(int i = 1971; i < year; i++){
            if(isLeap(i)){
                sum += 366;
            }else{
                sum += 365;
            }
        }
        for(int i = 0; i < month - 1; i++){
            if(isLeap(year) && i == 1){
                sum += 29;
            }else{
                sum += days[i];
            }
        }
        sum += day;
        return week[sum % 7];
    }
}