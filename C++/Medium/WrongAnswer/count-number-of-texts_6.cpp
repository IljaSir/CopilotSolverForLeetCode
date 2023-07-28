class Solution {
public:
    int countTexts(string pressedKeys) {
        
        const int M = 1e9 + 7;
        vector<int> dp(pressedKeys.size(), 1);
        for (int i = 1; i < pressedKeys.size(); ++i) {
            if (pressedKeys[i] == pressedKeys[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        long long res = 1;
        int i = 0;
        while (i < pressedKeys.size()) {
            int j = i;
            while (j < pressedKeys.size() && pressedKeys[j] == pressedKeys[i]) {
                ++j;
            }
            int cnt = j - i;
            if (cnt > 1) {
                res = res * (cnt + 1) % M;
            }
            i = j;
        }
        return res;
    }
};