class Solution {
public:
    int subarrayGCD(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(k);
        for (int i = 0; i < n; ++i) {
            cnt[nums[i] % k]++;
        }
        int ans = 0;
        for (int i = 1; i <= k / 2; ++i) {
            ans += max(cnt[i], cnt[k - i]);
        }
        if (cnt[0]) ans++;
        if (k % 2 == 0 && cnt[k / 2]) ans++;
        return ans;
    }
};