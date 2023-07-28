class Solution {
public:
    int countTexts(string pressedKeys) {
        
        int n = pressedKeys.length();
        if (n == 0) return 0;
        vector<int> dp(n, 0);
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (pressedKeys[i] == pressedKeys[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cur = pressedKeys[i] - '2';
            int cnt = 0;
            while (i < n && pressedKeys[i] == pressedKeys[i - cnt]) {
                cnt++;
                i++;
            }
            i--;
            ans = ans * (cnt + 1) % 1000000007;
        }
        return ans;
    }
};