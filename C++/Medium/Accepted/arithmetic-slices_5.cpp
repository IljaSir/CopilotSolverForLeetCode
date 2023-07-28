class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < n - 2; ++i) {
            int diff = nums[i + 1] - nums[i];
            int j = i + 2;
            for (; j < n; ++j) {
                if (nums[j] - nums[j - 1] != diff) {
                    break;
                }
            }
            int len = j - i;
            res += (len - 1) * (len - 2) / 2;
            i = j - 2;
        }
        return res;
    }
};