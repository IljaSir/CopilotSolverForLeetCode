class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int n = nums.size();
        int maxVal = nums[0];
        int minVal = nums[0];
        int maxProd = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                swap(maxVal, minVal);
            }
            maxVal = max(nums[i], maxVal * nums[i]);
            minVal = min(nums[i], minVal * nums[i]);
            maxProd = max(maxProd, maxVal);
        }
        return maxProd;
    }
};