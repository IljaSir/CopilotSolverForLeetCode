class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = upper_bound(nums.begin(), nums.end(), nums[i] + nums[j] - 1) - nums.begin();
                ans += k - j - 1;
            }
        }
        return ans;
    }
};