class Solution {
public:
    bool validPartition(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (nums[i] == nums[i + 1]) {
                i++;
            } else if (nums[j] == nums[j - 1]) {
                j--;
            } else {
                break;
            }
        }
        if (j - i < 2) return false;
        
        for (int k = i + 2; k <= j; k++) {
            if (nums[k] == nums[k - 1] && nums[k] == nums[k - 2]) {
                return true;
            }
        }
        
        for (int k = i + 1; k < j; k++) {
            if (nums[k] == nums[k - 1] + 1 && nums[k] == nums[k + 1] - 1) {
                return true;
            }
        }
        
        return false;
    }
};