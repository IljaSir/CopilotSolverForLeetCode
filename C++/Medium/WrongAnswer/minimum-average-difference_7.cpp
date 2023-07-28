class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        int min_index = -1;
        int min_diff = INT_MAX;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= 4) {
                int avg1 = (sum - nums[i - 4]) / 4;
                int avg2 = (sum - nums[i]) / (i + 1);
                int diff = abs(avg1 - avg2);
                if (diff < min_diff) {
                    min_diff = diff;
                    min_index = i - 3;
                }
            }
        }
        return min_index;
    }
};