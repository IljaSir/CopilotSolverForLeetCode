class Solution {
public:
    int maximizeGreatness(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int ans = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            ans += i - lower_bound(nums.begin(), nums.end(), nums[i]) + 1;
        }
        return ans;
    }
};