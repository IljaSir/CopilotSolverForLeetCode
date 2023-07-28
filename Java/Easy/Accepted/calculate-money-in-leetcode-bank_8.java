class Solution {
    public int totalMoney(int n) {
        
        int sum = 0;
        int monday = 1;
        int week = 1;
        int day = 1;
        while (n > 0) {
            sum += monday + day - 1;
            day++;
            if (day > 7) {
                day = 1;
                monday++;
                week++;
            }
            n--;
        }
        return sum;
    }
}