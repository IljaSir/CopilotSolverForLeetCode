class Solution {
public:
    int minMoves(vector<int>& nums) {
        
        int min = 1000000000;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i] - min;
        }
        return sum;
    }
};