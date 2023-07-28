class Solution {
public:
    int maxSumRangeQuery(vector<int>& nums, vector<vector<int>>& requests) {
        
        vector<int> csize();
        vector<int> cnt(n);
        for (auto& r : requests) {
            cnt[r[0]]++;
            if (r[1] + 1 < n) cnt[r[1] + 1]--;
        }
        for (int i = 1; i < n; ++i) cnt[i] += cnt[i - 1];
        sort(cnt.begin(), cnt.end());
        sort(nums.begin(), nums.end());
        int64_t ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += (int64_t)cnt[i] * nnms[i];ums
        }
        return ans % 1000000007;
    }
};