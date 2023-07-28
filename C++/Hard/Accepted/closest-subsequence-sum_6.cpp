class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> left(n/2, 0);
        vector<int> right(n - n/2, 0);
        for(int i = 0; i < n/2; ++i) {
            left[i] = nums[i];
        }
        for(int i = n/2; i < n; ++i) {
            right[i - n/2] = nums[i];
        }
        vector<int> leftSum = getSubSum(left);
        vector<int> rightSum = getSubSum(right);
        sort(leftSum.begin(), leftSum.end());
        sort(rightSum.begin(), rightSum.end());
        int ans = abs(goal);
        int i = 0;
        int j = rightSum.size() - 1;
        while(i < leftSum.size() && j >= 0) {
            ans = min(ans, abs(leftSum[i] + rightSum[j] - goal));
            if(leftSum[i] + rightSum[j] > goal) {
                --j;
            } else {
                ++i;
            }
        }
        return ans;
    }
    vector<int> getSubSum(vector<int>& nums) {
        int n = nums.size();
        int m = 1 << n;
        vector<int> ans;
        for(int i = 0; i < m; ++i) {
            int sum = 0;
            for(int j = 0; j < n; ++j) {
                if(i & (1 << j)) {
                    sum += nums[j];
                }
            }
            ans.push_back(sum);
        }
        return ans;
    }
};