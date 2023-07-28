class Solution {
public:
    vector<long long> minOperations(vector<int>& nums, vector<int>& queries) {
        
        vector<long long> res;
        int n = nums.size();
        int m = queries.size();
        vector<int> cnt(100001, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        vector<int> prefix(100001, 0);
        for (int i = 1; i <= 100000; i++) {
            prefix[i] = prefix[i - 1] + cnt[i];
        }
        for (int i = 0; i < m; i++) {
            int x = queries[i];
            long long ans = 0;
            for (int j = 1; j <= 100000; j++) {
                ans += abs(x - j) * 1LL * (prefix[min(100000, j + x - 1)] - prefix[j - 1]);
            }
            res.push_back(ans);
        }
        return res;
    }
};