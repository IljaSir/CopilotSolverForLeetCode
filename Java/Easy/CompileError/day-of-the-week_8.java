class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(weekDay < 0){
            weekDay = 0;
        }
        return weekDays[weekDay];
    }
}