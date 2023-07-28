class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size();
        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2) odd += nums[i];
            else even += nums[i];
        }
        int ans = 0;
        int odd2 = 0, even2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2) odd2 += nums[i];
            else even2 += nums[i];
            if (odd == odd2 + even - even2 && even == even2 + odd - odd2) {
                ans++;
            }
        }
        return ans;
    }
};