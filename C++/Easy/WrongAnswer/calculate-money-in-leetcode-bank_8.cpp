class Solution {
public:
    int totalMoney(int n) {
        
        int sum = 0;
        int week = n / 7;
        int day = n % 7;
        sum = (week * (week + 1) / 2) * 7 + (week * (week - 1) / 2) * 7;
        for (int i = 1; i <= day; ++i) {
            sum += week + i;
        }
        return sum;
    }
};