class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            int num = nums[i];
            int maxProductNext = max(num, max(num * maxProduct, num * minProduct));
            int minProductNext = min(num, min(num * maxProduct, num * minProduct));
            maxProduct = maxProductNext;
            minProduct = minProductNext;
            ans = max(ans, maxProduct);
        }
        return ans;
    }
};