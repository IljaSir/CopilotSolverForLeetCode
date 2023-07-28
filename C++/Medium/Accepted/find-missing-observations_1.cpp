class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        
        int m = rolls.size();
        int sum = accumulate(rolls.begin(), rolls.end(), 0);
        int target = (m + n) * mean - sum;
        if (target < n || target > 6 * n) {
            return {};
        }
        vector<int> ans(n);
        for (int i = 0; i < n; ++i) {
            int x = min(6, target - n + i + 1);
            ans[i] = x;
            target -= x;
        }
        return ans;
    }
};