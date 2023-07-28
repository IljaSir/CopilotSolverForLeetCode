class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        
        int m = rolls.size();
        int sum = accumulate(rolls.begin(), rolls.end(), 0);
        int total = mean * (m + n);
        int missing = total - sum;
        if (missing < n || missing > 6 * n) return {};
        vector<int> ans(n);
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
            missing -= 1;
        }
        for (int i = 0; i < n; i++) {
            if (missing >= 5) {
                ans[i] += 5;
                missing -= 5;
            } else {
                ans[i] += missing;
                missing = 0;
            }
        }
        return ans;
    }
};