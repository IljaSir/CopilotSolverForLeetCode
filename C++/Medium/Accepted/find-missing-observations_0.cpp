class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        
        int m = rolls.size();
        int sum = accumulate(rolls.begin(), rolls.end(), 0);
        int target = mean * (m + n) - sum;
        if (target < n || target > 6 * n) return {};
        vector<int> ans(n);
        for (int i = 0; i < n; ++i) {
            ans[i] = min(target - (n - i - 1), 6);
            target -= ans[i];
        }
        return ans;
    }
};