class Solution {
public:
    long long countExcellentPairs(vector<int>& nums, int k) {
        
        long long ans = 0;
        int n = nums.size();
        vector<int> cnt(61, 0);
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            int c = 0;
            while (x) {
                c += (x & 1);
                x >>= 1;
            }
            cnt[c]++;
        }
        for (int i = 0; i < 61; ++i) {
            for (int j = 0; j < 61; ++j) {
                if (i + j >= k) {
                    ans += cnt[i] * cnt[j];
                }
            }
        }
        return ans;
    }
};