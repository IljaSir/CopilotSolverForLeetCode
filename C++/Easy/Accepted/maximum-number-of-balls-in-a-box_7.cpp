class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        
        int ans = 0;
        vector<int> count(46, 0);
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int x = i;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            count[sum]++;
            ans = max(ans, count[sum]);
        }
        return ans;
    }
};