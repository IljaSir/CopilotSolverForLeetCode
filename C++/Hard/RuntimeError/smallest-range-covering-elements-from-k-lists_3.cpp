class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        vector<int> res;
        int k = nums.size();
        int n = nums[0].size();
        vector<int> index(k, 0);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int minVal = INT_MAX, maxVal = INT_MIN;
        for (int i = 0; i < k; i++) {
            pq.push({nums[i][0], i});
            maxVal = max(maxVal, nums[i][0]);
        }
        while (true) {
            auto t = pq.top();
            pq.pop();
            int i = t.second;
            minVal = t.first;
            if (maxVal - minVal < res.back() - res.front() || res.empty()) {
                res = {minVal, maxVal};
            }
            if (index[i] + 1 == n) {
                break;
            }
            index[i]++;
            pq.push({nums[i][index[i]], i});
            maxVal = max(maxVal, nums[i][index[i]]);
        }
        return res;
    }
};