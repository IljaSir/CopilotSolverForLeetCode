class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        
        vector<int> nums = {a, b, c};
        sort(nums.begin(), nums.end());
        int min = 0;
        if (nums[2] - nums[0] == 2) {
            min = 0;
        } else if (nums[2] - nums[1] <= 2 || nums[1] - nums[0] <= 2) {
            min = 1;
        } else {
            min = 2;
        }
        int max = nums[2] - nums[1] - 1 + nums[1] - nums[0] - 1;
        return vector<int>{min, max};
    }
};