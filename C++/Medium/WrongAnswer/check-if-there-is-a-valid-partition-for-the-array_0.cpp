class Solution {
public:
    bool validPartition(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            if (j - i >= 2) {
                i = j;
                continue;
            }
            int k = j + 1;
            while (k < n && nums[k] == nums[k - 1] + 1) {
                k++;
            }
            if (k - j >= 3) {
                i = k;
                continue;
            }
            return false;
        }
        return true;
    }
};