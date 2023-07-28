class Solution {
    public int totalMoney(int n) {
        
        int day = n % 7;
        int week = n / 7;
        int sum = 0;
        int base = 0;
        for (int i = 0; i < week; i++) {
            base += 7;
            sum += base;
        }
        base += day;
        sum += (day + 1) * day / 2;
        return sum;
    }
}