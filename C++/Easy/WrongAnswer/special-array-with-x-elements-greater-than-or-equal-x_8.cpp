class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        for (int i = 1; i <= n; i++) {
            if (i == nums[n-i]) {
                if (i == n || nums[n-i-1] < i) {
                    return i;
                }
            }
        }
        return -1;
    }
};