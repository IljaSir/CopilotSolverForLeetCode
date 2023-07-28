class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        int maxVal = 0;
        for (int num: nums) {
            maxVal = max(maxVal, num);
        }
        vector<int> sum(maxVal + 1);
        for (int num: nums) {
            sum[num] += num;
        }
        return rob(sum);
    }
    int rob(vector<int>& nums) {
        int size = nums.size();
        int first = nums[0], second = max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
};