class Solution {
public:
    bool validPartition(vector<int>& nums) {
        
        int n = nums.size();
        int l = 0, r = n - 1;
        while(l < n - 1 && nums[l] == nums[l + 1]) l++;
        while(r > 0 && nums[r] == nums[r - 1]) r--;
        if(l == n - 1 || r == 0) return false;
        if(nums[l] != nums[r]) return false;
        if(r - l < 2) return true;
        return nums[l + 1] == nums[r - 1];
    }
};