class Solution {
public:
    int totalMoney(int n) {
        
        int week = n / 7;
        int day = n % 7;
        int sum = 0;
        for (int i = 0; i < week; i++) {
            sum += (i + 1) * 7 + 21;
        }
        for (int i = 0; i < day; i++) {
            sum += week + i + 1;
        }
        return sum;
    }
};