class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int n = hours.size();
        vector<int> pre(n+1);
        for (int i = 0; i < n; ++i) {
            pre[i+1] = pre[i] + (hours[i] > 8 ? 1 : -1);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + ans; j < n; ++j) {
                if (pre[i] < pre[j+1]) {
                    ans = max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
};