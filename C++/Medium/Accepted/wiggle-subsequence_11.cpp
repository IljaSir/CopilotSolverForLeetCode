class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        
        if (nums.size() <= 1)
            return nums.size();
        int ans = 1;
        int last = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] > nums[i - 1]) {
                if (last != 1) {
                    ++ans;
                    last = 1;
                }
            } else if (nums[i] < nums[i - 1]) {
                if (last != -1) {
                    ++ans;
                    last = -1;
                }
            }
        }
        return ans;
    }
};