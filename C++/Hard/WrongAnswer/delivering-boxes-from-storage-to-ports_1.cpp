class Solution {
public:
    int boxDelivering(vector<vector<int>>& boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int n = boxes.size();
        vector<int> dp(n + 1, INT_MAX / 2);
        dp[0] = 0;
        int i = 0, j = 0;
        int weight = 0;
        int count = 0;
        while (i < n) {
            while (j < n && j - i < maxBoxes && weight + boxes[j][1] <= maxWeight) {
                weight += boxes[j][1];
                if (j == 0 || boxes[j][0] != boxes[j - 1][0]) {
                    count++;
                }
                j++;
            }
            int t = dp[i] + count + 2;
            for (int k = i; k < j; k++) {
                if (k == n - 1 || boxes[k][0] != boxes[k + 1][0]) {
                    t--;
                }
                dp[k + 1] = min(dp[k + 1], t);
            }
            weight -= boxes[i][1];
            if (i == j - 1 || boxes[i][0] != boxes[i + 1][0]) {
                count--;
            }
            i++;
        }
        return dp[n];
    }
};