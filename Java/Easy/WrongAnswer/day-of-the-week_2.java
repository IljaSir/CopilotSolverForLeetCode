class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int total = 0;
        int i;
        for(i = 1971;i < year;i++){
            if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
                total += 366;
            else
                total += 365;
        }
        for(i = 0;i < month - 1;i++){
            if(i == 1 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0))
                total += 29;
            else
                total += months[i];
        }
        total += day - 1;
        return days[total % 7];
    }
}