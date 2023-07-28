class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> left(n/2), right(n - n/2);
        for (int i = 0; i < n/2; ++i) {
            left[i] = nums[i];
        }
        for (int i = 0; i < n - n/2; ++i) {
            right[i] = nums[i + n/2];
        }
        vector<int> leftSum, rightSum;
        sumSubseq(left, leftSum);
        sumSubseq(right, rightSum);
        sort(rightSum.begin(), rightSum.end());
        int ans = abs(goal);
        for (int sum : leftSum) {
            int target = goal - sum;
            auto lb = lower_bound(rightSum.begin(), rightSum.end(), target);
            if (lb != rightSum.end()) {
                ans = min(ans, abs(target - *lb));
            }
            if (lb != rightSum.begin()) {
                ans = min(ans, abs(target - *prev(lb)));
            }
        }
        return ans;
    }

    void sumSubseq(vector<int>& nums, vector<int>& sum) {
        int n = nums.size();
        int m = 1 << n;
        for (int i = 0; i < m; ++i) {
            int cur = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j) & 1) {
                    cur += nums[j];
                }
            }
            sum.push_back(cur);
        }
    }
};