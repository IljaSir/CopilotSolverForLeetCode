class Solution {
public:
    int minNumberOfHours(int initialEnergy, int initialExperience, vector<int>& energy, vector<int>& experience) {
        
        int n = energy.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            int e = initialEnergy - energy[i];
            int exp = initialExperience - experience[i];
            if (e <= 0 && exp <= 0) return -1;
            if (e >= 0 && exp >= 0) continue;
            if (e < 0) {
                dp[i] = (abs(e) + 1) / 2;
            } else {
                dp[i] = (abs(exp) + 1) / 2;
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res = max(res, dp[i]);
        }
        return res;
    }
};