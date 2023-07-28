class Solution {
    public int daysBetweenDates(String date1, String date2) {
        
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] days2 = {31,29,31,30,31,30,31,31,30,31,30,31};
        int[] d1 = new int[3];
        int[] d2 = new int[3];
        for(int i=0;i<3;i++){
            d1[i]=Integer.parseInt(date1.split("-")[i]);
            d2[i]=Integer.parseInt(date2.split("-")[i]);
        }
        int year = d1[0];
        int month = d1[1];
        int day = d1[2];
        int sum = 0;
        while(year<d2[0]){
            if(year%4==0){
                sum+=366;
            }else{
                sum+=365;
            }
            year++;
        }
        while(month<d2[1]){
            if(year%4==0){
                sum+=days2[month-1];
            }else{
                sum+=days[month-1];
            }
            month++;
        }
        sum-=day;
        sum+=d2[2];
        return sum;
    }
}