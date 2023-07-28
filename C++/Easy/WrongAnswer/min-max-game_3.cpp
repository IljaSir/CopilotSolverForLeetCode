class Solution {
public:
    int minMaxGame(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        while (n > 1) {
            int j = 0;
            for (i = 0; i < n; i += 2) {
                nums[j++] = min(nums[i], nums[i + 1]);
            }
            n = j;
        }
        return nums[0];
    }
};