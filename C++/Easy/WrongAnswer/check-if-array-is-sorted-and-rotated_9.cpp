class Solution {
public:
    bool check(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        while(i < n && nums[i] == nums[0]) i++;
        if(i == n) return true;
        if(nums[i] < nums[0]) {
            while(i < n && nums[i] < nums[0]) i++;
            if(i == n) return true;
        }
        else {
            while(i < n && nums[i] > nums[0]) i++;
            if(i == n) return true;
        }
        return false;
    }
};