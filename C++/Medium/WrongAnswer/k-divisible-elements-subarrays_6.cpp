class Solution {
public:
    int countDistinct(vector<int>& nums, int k, int p) {
        
        int n = nums.size();
        vector<int> cnt(p);
        int ans = 0;
        for (int l = 0, r = 0; r < n; ++r) {
            if (++cnt[nums[r] % p] == 1) --k;
            while (k < 0) {
                if (--cnt[nums[l] % p] == 0) ++k;
                ++l;
            }
            ans += r - l + 1;
        }
        return ans;
    }
};