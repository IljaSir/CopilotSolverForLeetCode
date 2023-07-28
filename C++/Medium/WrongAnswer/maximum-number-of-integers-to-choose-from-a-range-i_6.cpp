class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        
        int ans = 0;
        sort(banned.begin(), banned.end());
        for (int i = 0; i < banned.size(); ++i) {
            if (i == 0) {
                ans += min(n, banned[i] - 1) - (maxSum - n) / (banned.size() + 1);
            } else {
                ans += min(n, banned[i] - banned[i - 1] - 1) - (maxSum - n) / (banned.size() + 1);
            }
        }
        ans += min(n, maxSum - banned.back()) - (maxSum - n) / (banned.size() + 1);
        return ans;
    }
};