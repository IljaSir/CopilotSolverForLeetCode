class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        long long sum = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] < nums[i + 1]) {
                    sum += nums[i];
                    nums[i] = INT_MAX;
                }
            } else if (i == n - 1) {
                if (nums[i] < nums[i - 1]) {
                    sum += nums[i];
                    nums[i] = INT_MAX;
                }
            } else {
                if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                    sum += nums[i];
                    nums[i] = INT_MAX;
                }
            }
        }
        return sum;
    }
};