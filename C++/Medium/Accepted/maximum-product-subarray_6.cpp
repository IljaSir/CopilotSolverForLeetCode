class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int n = nums.size();
        int maxProd = nums[0];
        int minProd = nums[0];
        int maxAns = nums[0];
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            int newMax = max({curr, maxProd * curr, minProd * curr});
            int newMin = min({curr, maxProd * curr, minProd * curr});
            maxProd = newMax;
            minProd = newMin;
            maxAns = max(maxAns, maxProd);
        }
        return maxAns;
    }
};