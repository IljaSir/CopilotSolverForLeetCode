class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        int row = destination[0], col = destination[1];
        int dp[row + col + 1];
        dp[0] = 1;
        for (int i = 1; i <= row + col; ++i) dp[i] = dp[i - 1] * i;
        string ans;
        int i = 0, j = 0;
        while (i < row || j < col) {
            int total = 0;
            if (i < row) total = dp[row + col - i - j - 1] / dp[col - j];
            if (k > total) {
                ans += 'V';
                ++i;
                k -= total;
            }
            else {
                ans += 'H';
                ++j;
            }
        }
        return ans;
    }
};