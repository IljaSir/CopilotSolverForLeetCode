class Solution {
public:
    int countArrangement(int n) {
        
        vector<int> nums(n);
        iota(nums.begin(), nums.end(), 1);
        return countArrangement(nums, 0);
    }
    int countArrangement(vector<int>& nums, int i) {
        if (i == nums.size()) {
            return 1;
        }
        int res = 0;
        for (int j = i; j < nums.size(); ++j) {
            if (nums[j] % (i + 1) == 0 || (i + 1) % nums[j] == 0) {
                swap(nums[i], nums[j]);
                res += countArrangement(nums, i + 1);
                swap(nums[i], nums[j]);
            }
        }
        return res;
    }
};