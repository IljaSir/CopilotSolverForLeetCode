class Solution {
    public int totalMoney(int n) {
        
        int sum = 0;
        int day = 1;
        int week = 1;
        for (int i = 0; i < n; i++) {
            if (day > 7) {
                day = 1;
                week++;
            }
            sum += day + week - 1;
            day++;
        }
        return sum;
    }
}