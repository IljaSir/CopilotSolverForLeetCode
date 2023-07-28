class Solution {
public:
    int destroyTargets(vector<int>& nums, int space) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 1;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] <= space) {
                j++;
            }
            ans = max(ans, j - i);
            i = j;
        }
        return ans;
    }
};