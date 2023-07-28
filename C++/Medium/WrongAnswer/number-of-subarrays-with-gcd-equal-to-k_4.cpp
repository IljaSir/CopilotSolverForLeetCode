class Solution {
public:
    int subarrayGCD(vector<int>& nums, int k) {
        
        if (k == 1) return nums.size();
        int n = nums.size();
        vector<int> cnt(k);
        for (int x : nums) {
            ++cnt[x % k];
        }
        int ans = 0;
        for (int i = 1; i <= k / 2; ++i) {
            if (k % i == 0) {
                ans += max(cnt[i], cnt[k - i]);
            }
        }
        ans += cnt[0] > 0;
        return ans;
    }
};