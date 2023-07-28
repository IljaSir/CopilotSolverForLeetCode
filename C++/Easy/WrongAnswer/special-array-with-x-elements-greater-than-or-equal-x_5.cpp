class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        for (int i = 0; i <= n; ++i) {
            if (i == n || nums[n - i - 1] < i) {
                return i;
            }
        }
        return -1;
    }
};