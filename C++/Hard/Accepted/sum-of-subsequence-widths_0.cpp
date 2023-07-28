class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {
        
        int mod = 1e9 + 7;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> pows(n);
        pows[0] = 1;
        for (int i = 1; i < n; i++) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        long long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (long long)nums[i] * (pows[i] - pows[n - i - 1])) % mod;
        }
        return res;
    }
};