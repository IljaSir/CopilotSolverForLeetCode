class Solution {
public:
    int minImpossibleOR(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 1;
        for (int i = 0; i < n && ans >= nums[i]; ++i) {
            ans += nums[i];
        }
        return ans;
    }
};