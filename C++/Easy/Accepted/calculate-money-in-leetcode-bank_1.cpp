class Solution {
public:
    int totalMoney(int n) {
        
        int week = n / 7;
        int day = n % 7;
        int res = 0;
        for (int i = 0; i < week; i++) {
            res += 28 + i * 7;
        }
        for (int i = 0; i < day; i++) {
            res += week + i + 1;
        }
        return res;
    }
};