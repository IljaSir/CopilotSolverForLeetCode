class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int size = nums.size();
        if (size == 0) return 0;
        int minVal = nums[0];
        int maxVal = nums[0];
        int maxProd = nums[0];
        for (int i = 1; i < size; ++i) {
            int tmp = maxVal;
            maxVal = max(max(maxVal * nums[i], minVal * nums[i]), nums[i]);
            minVal = min(min(tmp * nums[i], minVal * nums[i]), nums[i]);
            maxProd = max(maxProd, maxVal);
        }
        return maxProd;
    }
};