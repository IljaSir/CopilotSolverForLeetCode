class Solution {
public:
    int minDeletion(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) return 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]) {
                ans++;
                i++;
            }
        }
        return ans;
    }
};