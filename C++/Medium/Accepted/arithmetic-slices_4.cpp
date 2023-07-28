class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int d = nums[i + 1] - nums[i];
            int j = i + 2;
            while (j < n && nums[j] - nums[j - 1] == d) {
                j++;
            }
            if (j - i >= 3) {
                res += (j - i - 2) * (j - i - 1) / 2;
            }
            i = j - 2;
        }
        return res;
    }
};