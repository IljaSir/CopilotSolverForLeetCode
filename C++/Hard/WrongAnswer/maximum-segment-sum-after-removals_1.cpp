class Solution {
public:
    vector<long long> maximumSegmentSum(vector<int>& nums, vector<int>& removeQueries) {
        
        vector<long long> ans;
        vector<int> removed(nums.size(), 0);
        for (int i = 0; i < removeQueries.size(); i++) {
            removed[removeQueries[i]] = 1;
        }
        long long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (removed[i] == 0) {
                sum += nums[i];
            }
        }
        ans.push_back(sum);
        for (int i = removeQueries.size() - 1; i >= 0; i--) {
            int idx = removeQueries[i];
            long long left = 0;
            long long right = 0;
            int j = idx - 1;
            while (j >= 0) {
                if (removed[j] == 0) {
                    left += nums[j];
                }
                j--;
            }
            j = idx + 1;
            while (j < nums.size()) {
                if (removed[j] == 0) {
                    right += nums[j];
                }
                j++;
            }
            long long maxSum = max(left, right);
            if (maxSum > 0) {
                sum += maxSum;
            }
            ans.push_back(sum);
            removed[idx] = 0;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};