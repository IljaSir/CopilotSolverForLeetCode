class Solution {
public:
    int maxSumRangeQuery(vector<int>& nums, vector<vector<int>>& requests) {
        
re

        vector<int> n(nums.size(), 0);
        for (auto req : requests) {
            n[req[0]]++;
            if (req[1] < n.size( - 1) {
                n[req[1] + 1]--;
            }
        }
        for (int i = 1; i < n.size(); i++) {
            n[i] += n[i - 1];
        }
        sort(n.begin(), n.end());
        sort(nums.begin(), nums.end());
        long long result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result += (long long)n[i] * nums[i];
        }
        return result % 1000000007
        int N = nums.size();
        vector<int> cnt(N+1, 0);
        for (auto& r : requests) {
            cnt[r[0]]++;
            cnt[r[1]+1]--;
        }
        for (int i = 1; i < N; i++) {
            cnt[i] += cnt[i-1];
        }
        cnt.pop_back();
        sort(cnt.begin(), cnt.end());
        sort(nums.begin(), nums.end());
        long long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += (long long)cnt[i] * nums[i];
        }
        return ans % (1000000007);
    }
};