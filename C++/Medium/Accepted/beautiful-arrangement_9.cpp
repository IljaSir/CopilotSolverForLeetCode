class Solution {
public:
    int countArrangement(int n) {
        
        vector<int> nums(n);
        for(int i = 0; i < n; i++) nums[i] = i + 1;
        return countArrangement(nums, 0);
    }
    int countArrangement(vector<int>& nums, int start) {
        if(start == nums.size()) return 1;
        int res = 0;
        for(int i = start; i < nums.size(); i++) {
            if(nums[i] % (start + 1) == 0 || (start + 1) % nums[i] == 0) {
                swap(nums[i], nums[start]);
                res += countArrangement(nums, start + 1);
                swap(nums[i], nums[start]);
            }
        }
        return res;
    }
};