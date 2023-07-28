class Solution {
public:
    int maxNumOfMarkedIndices(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = upper_bound(nums.begin(), nums.end(), 2 * nums[i]) - nums.begin();
            ans = max(ans, j - i);
        }
        return ans;
    }
};