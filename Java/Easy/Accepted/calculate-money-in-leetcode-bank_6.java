class Solution {
    public int totalMoney(int n) {
        
        int total = 0;
        int week = n/7;
        int day = n%7;
        int start = 1;
        for(int i=0; i<week; i++){
            total += 7*start + 21;
            start++;
        }
        for(int i=0; i<day; i++){
            total += start + i;
        }
        return total;
    }
}