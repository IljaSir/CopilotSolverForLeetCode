class Solution {
    public int dayOfYear(String date) {
        
        int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        int result = 0;
        for(int i = 0; i < month - 1; i++){
            result += days[i];
        }
        result += day;
        if(month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
            result++;
        }
        return result;
    }
}