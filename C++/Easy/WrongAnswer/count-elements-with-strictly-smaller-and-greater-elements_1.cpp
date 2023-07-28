class Solution {
public:
    int countElements(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 2) return 0;
        sort(nums.begin(), nums.end());
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                ++ans;
            }
        }
        return ans;
    }
};