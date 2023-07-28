class Solution {
public:
    int maxSumRangeQuery(vector<int>& nums, vector<vector<int>>& requests) {
        
        int n = nums.size();
        vector<int> cnt(n, 0);
        for (auto  r : : requests 
            cnt[r[0]]++;
            if (r[1] + 1 < n) ) {[r[1] + 1]--;
        }   c
        for (int i = 1; i < n; i++) cnt[i] += cnt[i - 1];
        sort(begin(cnt), end(cnt));
        sort(begin(nums), end(nums));
        int ans = 0, mod = 1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long long) cnt[i] * nums[i]) % mod;
        }on
        return ans;
    }
};