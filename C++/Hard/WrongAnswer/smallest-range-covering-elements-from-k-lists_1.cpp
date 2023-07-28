class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        int n = nums.size();
        vector<int> idx(n, 0);
        auto cmp = [&nums, &idx](int x, int y){
            return nums[x][idx[x]] > nums[y][idx[y]];
        };
        priority_queue<int, vector<int>, decltype(cmp)> pq(cmp);
        int minVal = INT_MAX;
        int maxVal = INT_MIN;
        for (int i = 0; i < n; ++i) {
            pq.push(i);
            minVal = min(minVal, nums[i][0]);
            maxVal = max(maxVal, nums[i][0]);
        }
        int rangeLeft = minVal;
        int rangeRight = maxVal;
        while (true) {
            int i = pq.top();
            pq.pop();
            if (rangeRight - rangeLeft > maxVal - minVal) {
                rangeLeft = minVal;
                rangeRight = maxVal;
            }
            if (idx[i] + 1 == nums[i].size()) {
                break;
            }
            ++idx[i];
            minVal = min(minVal, nums[i][idx[i]]);
            maxVal = max(maxVal, nums[i][idx[i]]);
            pq.push(i);
        }
        return {rangeLeft, rangeRight};
    }
};