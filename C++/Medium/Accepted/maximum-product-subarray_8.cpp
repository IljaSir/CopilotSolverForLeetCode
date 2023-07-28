class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int n = nums.size();
        int maxProd = 1;
        int minProd = 1;
        int ans = INT_MIN;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) swap(maxProd, minProd);
            maxProd = max(maxProd * nums[i], nums[i]);
            minProd = min(minProd * nums[i], nums[i]);
            ans = max(ans, maxProd);
        }
        return ans;
    }
};