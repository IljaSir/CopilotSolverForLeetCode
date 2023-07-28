class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 1;
        int i = 0;
        while (k--) {
            ans *= nums[i];
            ans %= 1e9 + 7;
            i++;
        }
        return ans;
    }
};