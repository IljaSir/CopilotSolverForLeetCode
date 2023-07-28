class Solution {
public:
    int boxDelivering(vector<vector<int>>& boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int n = boxes.size();
        vector<int> next(n);
        int right = 0, weight = 0;
        for (int left = 0; left < n; ++left) {
            while (right < n && (right == left || boxes[right][0] == boxes[right - 1][0] || weight + boxes[right][1] <= maxWeight)) {
                weight += boxes[right][1];
                ++right;
            }
            next[left] = right;
            weight -= boxes[left][1];
        }

        vector<int> dp(n + 1, INT_MAX / 2);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            dp[next[i]] = min(dp[next[i]], dp[i] + 2);
            dp[next[i] - 1] = min(dp[next[i] - 1], dp[i] + 1);
        }
        return dp[n] - 1;
    }
};