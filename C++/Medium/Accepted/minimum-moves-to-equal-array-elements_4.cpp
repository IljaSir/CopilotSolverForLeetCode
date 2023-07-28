class Solution {
public:
    int minMoves(vector<int>& nums) {
        
        int min = INT_MAX;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return sum - min * nums.size();
    }
};