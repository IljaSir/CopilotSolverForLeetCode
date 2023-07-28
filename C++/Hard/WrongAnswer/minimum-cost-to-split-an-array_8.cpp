class Solution {
public:
    int minCost(vector<int>& nums, int k) {
        
        int n = nums.size();
        map<int, int> cnt;
        for (int i = 0; i < n; ++i) {
            cnt[nums[i]]++;
        }
        vector<int> vals;
        for (auto p: cnt) {
            if (p.second > 1) {
                vals.push_back(p.second);
            }
        }
        sort(vals.begin(), vals.end());
        
        int m = vals.size();
        vector<int> prefix(m + 1);
        for (int i = 0; i < m; ++i) {
            prefix[i + 1] = prefix[i] + vals[i];
        }
        
        int ans = n * k;
        for (int i = 1; i <= m; ++i) {
            int left = i - 1;
            int right = m - i;
            int cost = (left + 1) * k + prefix[i] + (prefix[m] - prefix[i]);
            ans = min(ans, cost);
        }
        return ans;
    }
};