class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        
        int len = nums.size();
        vector<int> minRight(len, INT_MAX);
        for (int i = len-2; i >= 0; --i) {
            minRight[i] = min(minRight[i+1], nums[i+1]);
        }
        int maxLeft = nums[0];
        int sum = 0;
        for (int i = 1; i < len-1; ++i) {
            if (nums[i] > maxLeft && nums[i] < minRight[i]) {
                sum += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                sum += 1;
            }
            maxLeft = max(maxLeft, nums[i]);
        }
        return sum;
    }
};