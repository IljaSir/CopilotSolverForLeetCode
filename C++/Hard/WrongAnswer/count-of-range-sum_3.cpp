class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        
        int n = nums.size();
        vector<long long> presum(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        auto cmp = [](const pair<long long, int>& a, const pair<long long, int>& b) {
            return a.first < b.first;
        };
        set<pair<long long, int>, decltype(cmp)> s(cmp);
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            auto it1 = s.lower_bound({presum[i] - upper, 0});
            auto it2 = s.upper_bound({presum[i] - lower, 0});
            while (it1 != it2) {
                ans++;
                it1++;
            }
            s.insert({presum[i], i});
        }
        return ans;
    }
};