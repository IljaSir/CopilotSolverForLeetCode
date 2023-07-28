class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        return week[c.get(Calendar.DAY_OF_WEEK) - 1];
    }
}