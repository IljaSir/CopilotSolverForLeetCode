class Solution {
public:
    bool canBeIncreasing(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        while (i < n-1 && nums[i] < nums[i+1]) {
            i++;
        }
        if (i == n-1) return true;
        int j = i+1;
        while (j < n-1 && nums[j] < nums[j+1]) {
            j++;
        }
        if (j == n-1) return true;
        if (i == 0) return true;
        if (nums[i-1] < nums[j]) return true;
        if (j == n-1) return true;
        if (nums[i] < nums[j+1]) return true;
        return false;
    }
};