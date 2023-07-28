class Solution {
public:
    int maxNumOfMarkedIndices(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int i = 0;
        int j = 0;
        int n = nums.size();
        int ans = 0;
        while (j < n) {
            if (nums[j] >= 2 * nums[i]) {
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }
};