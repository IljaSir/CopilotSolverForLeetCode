class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        int cnt[100] = {0};
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            for (int j = i; j > 0; j /= 10) {
                sum += j % 10;
            }
            cnt[sum - 1]++;
        }
        int ans = 0;
        for (int i : cnt) {
            ans = max(ans, i);
        }
        return ans;
    }
};