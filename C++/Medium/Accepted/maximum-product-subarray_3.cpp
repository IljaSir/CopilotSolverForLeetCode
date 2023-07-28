class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int n = nums.size();
        int ans = nums[0];
        int max_prod = nums[0];
        int min_prod = nums[0];
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            int temp_max = max({curr, curr*max_prod, curr*min_prod});
            int temp_min = min({curr, curr*max_prod, curr*min_prod});
            max_prod = temp_max;
            min_prod = temp_min;
            ans = max(ans, max_prod);
        }
        return ans;
    }
};