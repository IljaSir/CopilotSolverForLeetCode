class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 1) return n;
        int ans = 1;
        int last = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i-1]) {
                if (last == 0 || (last > 0 && nums[i] < nums[i-1]) || (last < 0 && nums[i] > nums[i-1])) {
                    ans++;
                    last = nums[i] - nums[i-1];
                }
            }
        }
        return ans;
    }
};