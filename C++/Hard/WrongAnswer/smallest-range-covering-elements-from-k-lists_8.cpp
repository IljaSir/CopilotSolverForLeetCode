class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        int n = nums.size();
        vector<int> next(n, 0), minVal(n, 0);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int range = INT_MAX, left = -1, right = -1;
        for (int i = 0; i < n; i++) {
            pq.emplace(nums[i][0], i);
            minVal[i] = nums[i][0];
        }
        while (true) {
            auto [x, i] = pq.top();
            pq.pop();
            if (range > minVal[i] - x) {
                range = minVal[i] - x;
                left = x;
                right = minVal[i];
            }
            if (next[i] + 1 == nums[i].size()) {
                break;
            }
            next[i]++;
            minVal[i] = nums[i][next[i]];
            pq.emplace(minVal[i], i);
        }
        return {left, right};
    }
};