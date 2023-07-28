class Solution {
public:
    int totalMoney(int n) {
        
        int sum = 0;
        int week = n / 7;
        int day = n % 7;
        int start = 1;
        for (int i = 0; i < week; ++i) {
            sum += 7 * start + 21;
            start++;
        }
        for (int i = 0; i < day; ++i) {
            sum += start + i;
        }
        return sum;
    }
};