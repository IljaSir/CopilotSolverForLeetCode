class Solution {
public:
    long long countExcellentPairs(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> v(60, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 60; ++j) {
                if (nums[i] & (1LL << j)) {
                    ++v[j];
                }
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            long long sum = 0;
            for (int j = 0; j < 60; ++j) {
                if (nums[i] & (1LL << j)) {
                    sum += n - v[j];
                } else {
                    sum += v[j];
                }
            }
            if (sum >= k) {
                ++ans;
            }
        }
        return ans;
    }
};