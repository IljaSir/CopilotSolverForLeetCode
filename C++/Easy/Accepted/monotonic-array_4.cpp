class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return true;
        int i = 0;
        while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        if (i == n - 1) return true;
        bool inc = nums[i] < nums[i + 1];
        for (i = i + 1; i < n - 1; i++) {
            if (inc && nums[i] > nums[i + 1]) return false;
            if (!inc && nums[i] < nums[i + 1]) return false;
        }
        return true;
    }
};