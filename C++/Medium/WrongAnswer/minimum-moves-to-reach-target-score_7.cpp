class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        
        int dp[1000050] = {0};
        int i = 1;
        int j = 1;
        int inc = 1;
        int dou = 1;
        int ans = 0;
        while (i < target) {
            while (j < i) {
                j *= 2;
                dou++;
            }
            if (j == i) {
                dp[i] = dou;
            } else {
                dp[i] = min(inc + dp[i - 1], dou + dp[j - i]);
            }
            i++;
            inc++;
        }
        return dp[target];
    }
};