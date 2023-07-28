class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        while (i < n-1 && nums[i] == nums[i+1]) i++;
        if (i == n-1) return true;
        bool increasing = nums[i] < nums[i+1];
        for (int j = i+1; j < n-1; j++) {
            if (increasing && nums[j] > nums[j+1]) return false;
            if (!increasing && nums[j] < nums[j+1]) return false;
        }
        return true;
    }
};