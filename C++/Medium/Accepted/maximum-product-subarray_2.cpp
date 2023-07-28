class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int n = nums.size();
        int ans = nums[0];
        int max_val = nums[0];
        int min_val = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) swap(max_val, min_val);
            max_val = max(nums[i], max_val * nums[i]);
            min_val = min(nums[i], min_val * nums[i]);
            ans = max(ans, max_val);
        }
        return ans;
    }
};