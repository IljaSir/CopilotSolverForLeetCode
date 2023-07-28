class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int n = nums.size();
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int ans = nums[0];
        
        for (int i = 1; i < n; i++) {
            int maxTemp = maxProduct;
            int minTemp = minProduct;
            maxProduct = max(max(maxTemp*nums[i], minTemp*nums[i]), nums[i]);
            minProduct = min(min(maxTemp*nums[i], minTemp*nums[i]), nums[i]);
            ans = max(ans, maxProduct);
        }
        return ans;
    }
};