class Solution {
public:
    bool validPartition(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && nums[j] == nums[i]) {
                ++j;
            }
            if (j - i >= 2) {
                i = j;
                continue;
            }
            if (j == n) {
                return false;
            }
            int k = j + 1;
            while (k < n && nums[k] == nums[k - 1] + 1) {
                ++k;
            }
            if (k - j < 3) {
                return false;
            }
            i = k;
        }
        return true;
    }
};