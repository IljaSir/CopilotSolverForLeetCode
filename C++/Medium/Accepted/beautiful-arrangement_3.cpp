class Solution {
public:
    int countArrangement(int n) {
        
        vector<int> nums;
        for (int i = 1; i <= n; i++) {
            nums.push_back(i);
        }
        return countArrangement(nums, 0);
    }
    int countArrangement(vector<int>& nums, int start) {
        if (start == nums.size()) {
            return 1;
        }
        int count = 0;
        for (int i = start; i < nums.size(); i++) {
            if (nums[i] % (start + 1) == 0 || (start + 1) % nums[i] == 0) {
                swap(nums[i], nums[start]);
                count += countArrangement(nums, start + 1);
                swap(nums[i], nums[start]);
            }
        }
        return count;
    }
};