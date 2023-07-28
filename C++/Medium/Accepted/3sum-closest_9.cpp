class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        
        int minDiff = INT_MAX;
        int minSum = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; ++i) {
            int l = i + 1;
            int r = nums.size() - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = sum - target;
                if (diff == 0) {
                    return sum;
                }
                if (abs(diff) < abs(minDiff)) {
                    minDiff = diff;
                    minSum = sum;
                }
                if (diff > 0) {
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return minSum;
    }
};