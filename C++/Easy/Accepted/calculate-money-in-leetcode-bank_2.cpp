class Solution {
public:
    int totalMoney(int n) {
        
        int total = 0;
        int week = n / 7;
        int day = n % 7;
        for (int i = 0; i < week; ++i) {
            total += 28 + i * 7;
        }
        for (int i = 0; i < day; ++i) {
            total += 1 + i + week;
        }
        return total;
    }
};