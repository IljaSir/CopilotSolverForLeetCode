class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        int k = nums.size();
        vector<int> ans = {0, 100000};
        vector<int> next(k, 0);
        auto cmp = [&](int i, int j) {
            return nums[i][next[i]] > nums[j][next[j]];
        };
        priority_queue<int, vector<int>, decltype(cmp)> pq(cmp);
        int maxVal = INT_MIN;
        for (int i = 0; i < k; i++) {
            pq.push(i);
            maxVal = max(maxVal, nums[i][0]);
        }
        while (true) {
            int row = pq.top();
            pq.pop();
            int minVal = nums[row][next[row]];
            if (maxVal - minVal < ans[1] - ans[0]) {
                ans[0] = minVal;
                ans[1] = maxVal;
            }
            if (next[row] + 1 == nums[row].size()) {
                break;
            }
            next[row]++;
            maxVal = max(maxVal, nums[row][next[row]]);
            pq.push(row);
        }
        return ans;
    }
};