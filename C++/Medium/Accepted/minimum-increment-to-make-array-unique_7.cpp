class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        
        if (nums.size() < 2) return 0;
        sort(nums.begin(), nums.end());
        int moves = 0;
        int last = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] <= last) {
                moves += last + 1 - nums[i];
                nums[i] = last + 1;
            }
            last = nums[i];
        }
        return moves;
    }
};