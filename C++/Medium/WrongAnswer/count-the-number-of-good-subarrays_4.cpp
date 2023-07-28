class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(n + 1);
        int tot = 0;
        long long ret = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] & 1) {
                tot++;
            }
            if (tot >= k) {
                ret += cnt[tot - k];
            }
            cnt[tot]++;
        }
        return ret;
    }
};