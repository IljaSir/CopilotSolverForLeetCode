class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n) {
                if (nums[i] == nums[i + 1]) {
                    ans++;
                    nums[i + 1]++;
                }
            }
        }
        for (int i = 1; i < n; i += 2) {
            if (i + 1 < n) {
                if (nums[i] == nums[i + 1]) {
                    ans++;
                    nums[i + 1]++;
                }
            }
        }
        return ans;
    }
};