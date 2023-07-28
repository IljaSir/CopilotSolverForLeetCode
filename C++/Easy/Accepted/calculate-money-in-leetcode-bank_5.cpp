class Solution {
public:
    int totalMoney(int n) {
        
        int sum = 0;
        int week = 0;
        int day = 1;
        for (int i = 1; i <= n; i++) {
            sum += day + week;
            day++;
            if (day == 8) {
                day = 1;
                week++;
            }
        }
        return sum;
    }
};