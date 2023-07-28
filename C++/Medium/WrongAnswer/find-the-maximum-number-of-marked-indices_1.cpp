class Solution {
public:
    int maxNumOfMarkedIndices(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j + 1 < n && nums[j + 1] <= nums[i] * 2) {
                j++;
            }
            ans = max(ans, j - i + 1);
        }
        return ans;
    }
};