class Solution {
public:
    int countElements(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int cnt = 0;
        int n = nums.size();
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ++cnt;
            }
        }
        return cnt;
    }
};