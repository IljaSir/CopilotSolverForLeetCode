class Solution {
public:
    bool validPartition(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        if (n == 3) return nums[0] == nums[1] && nums[1] == nums[2];
        if (n == 4) return nums[0] == nums[1] && nums[2] == nums[3];
        int i = 0;
        while (i < n - 1) {
            if (nums[i] != nums[i + 1]) break;
            i++;
        }
        if (i == n - 1) return true;
        int j = n - 1;
        while (j > 0) {
            if (nums[j] != nums[j - 1]) break;
            j--;
        }
        if (j == 0) return true;
        if (nums[i] == nums[j]) return true;
        int k = i + 1;
        while (k < n - 1) {
            if (nums[k] != nums[k + 1]) break;
            k++;
        }
        if (k == n - 1) return true;
        if (nums[k] == nums[j]) return true;
        if (nums[i] == nums[k]) return true;
        if (nums[i] + 1 == nums[k] && nums[k] + 1 == nums[j]) return true;
        if (nums[i] + 1 == nums[j]) return true;
        if (nums[i] + 1 == nums[k] && nums[k] == nums[j]) return true;
        if (nums[i] == nums[k] && nums[k] == nums[j]) return true;
        return false;
    }
};