class Solution {
public:
    int minImpossibleOR(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int ans = 1;
        for (int i = 0; i < nums.size() && nums[i] <= ans; ++i)
            ans += nums[i];
        return ans;
    }
};