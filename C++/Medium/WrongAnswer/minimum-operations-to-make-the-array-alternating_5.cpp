class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                ans++;
                nums[i + 1]++;
            }
            if (i + 2 < n && nums[i] == nums[i + 2]) {
                ans++;
                nums[i + 2]++;
            }
        }
        return ans;
    }
};