class Solution {
    public int dayOfYear(String date) {
        
        int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        int res = 0;
        for(int i=0; i<month-1; i++){
            res += days[i];
        }
        if(year%4==0 && year%100!=0 || year%400==0){
            if(month>2) res++;
        }
        return res + day;
    }
}