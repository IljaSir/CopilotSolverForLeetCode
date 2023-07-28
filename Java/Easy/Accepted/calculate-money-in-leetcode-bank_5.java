class Solution {
    public int totalMoney(int n) {
        
        int result = 0;
        int week = 0;
        int day = 0;
        int money = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 1) {
                week++;
                day = 1;
                money = week;
            } else {
                day++;
                money++;
            }
            result += money;
        }
        return result;
    }
}