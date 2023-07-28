class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        int k = nums.size();
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int lo = INT_MAX, hi = INT_MIN;
        for (int i = 0; i < k; ++i) {
            pq.push({nums[i][0], i});
            lo = min(lo, nums[i][0]);
            hi = max(hi, nums[i][0]);
        }
        vector<int> ans = {lo, hi};
        vector<int> idx(k, 0);
        int diff = hi - lo;
        while (true) {
            int num = pq.top().first, i = pq.top().second;
            pq.pop();
            if (hi - num < diff) {
                diff = hi - num;
                ans = {num, hi};
            }
            if (idx[i] + 1 == nums[i].size()) break;
            ++idx[i];
            pq.push({nums[i][idx[i]], i});
            hi = max(hi, nums[i][idx[i]]);
        }
        return ans;
    }
};