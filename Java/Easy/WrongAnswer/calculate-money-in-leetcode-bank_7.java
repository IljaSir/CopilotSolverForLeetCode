class Solution {
    public int totalMoney(int n) {
        
        int sum = 0;
        int start = 1;
        int startDay = 1;
        for(int i = 1; i <= n; i++){
            sum += start;
            if(i % 7 == 0){
                start++;
                startDay = 1;
            }else{
                startDay++;
            }
            start = startDay;
        }
        return sum;
    }
}