class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal == 0) return true;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        vector<int> dp(1 << maxChoosableInteger, -1);
        return canIWin(maxChoosableInteger, desiredTotal, 0, dp);
    }
    
    bool canIWin(int maxChoosableInteger, int desiredTotal, int used, vector<int>& dp) {
        if (dp[used] != -1) return dp[used];
        for (int i = 0; i < maxChoosableInteger; i++) {
            int cur = 1 << i;
            if ((used & cur) == 0) {
                if (desiredTotal <= i + 1 || !canIWin(maxChoosableInteger, desiredTotal - i - 1, used | cur, dp)) {
                    dp[used] = 1;
                    return true;
                }
            }
        }
        dp[used] = 0;
        return false;
    }
};