class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        int MOD = 1e9 + 7;
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            int left = i, right = i;
            while (left - 1 >= 0 && strength[left - 1] >= strength[i]) --left;
            while (right + 1 < n && strength[right + 1] > strength[i]) ++right;
            res = (res + 1LL * strength[i] * (i - left + 1) * (right - i + 1)) % MOD;
        }
        return res;
    }
};