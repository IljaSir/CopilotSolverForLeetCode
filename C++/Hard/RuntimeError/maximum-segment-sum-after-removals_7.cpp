class Solution {
public:
    vector<long long> maximumSegmentSum(vector<int>& nums, vector<int>& removeQueries) {
        
        vector<long long> ans;
        unordered_map<int, int> removed;
        int n = nums.size();
        vector<long long> presum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + nums[i];
        }
        vector<int> removedIdx;
        for (int i = 0; i < n; ++i) {
            removedIdx.push_back(removeQueries[i]);
            removed[removeQueries[i]] = 1;
            long long maxSum = presum[n];
            for (int j = 0; j < removedIdx.size(); ++j) {
                if (removedIdx[j] == 0) {
                    maxSum = max(maxSum, presum[removedIdx[j + 1] + 1]);
                } else if (removedIdx[j] == n - 1) {
                    maxSum = max(maxSum, presum[n] - presum[removedIdx[j]]);
                } else {
                    maxSum = max(maxSum, presum[removedIdx[j + 1] + 1] - presum[removedIdx[j]]);
                }
            }
            ans.push_back(maxSum);
        }
        return ans;
    }
};