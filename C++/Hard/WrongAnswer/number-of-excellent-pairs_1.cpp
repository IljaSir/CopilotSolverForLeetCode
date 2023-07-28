class Solution {
public:
    long long countExcellentPairs(vector<int>& nums, int k) {
        
        long long res = 0;
        int n = nums.size();
        vector<int> cnt(60, 0);
        for (int num : nums) {
            for (int i = 0; i < 60; ++i) {
                if (num & (1LL << i)) {
                    ++cnt[i];
                }
            }
        }
        for (int num : nums) {
            for (int i = 0; i < 60; ++i) {
                if (num & (1LL << i)) {
                    res += n - cnt[i];
                } else {
                    res += cnt[i];
                }
            }
        }
        return res / 2;
    }
};