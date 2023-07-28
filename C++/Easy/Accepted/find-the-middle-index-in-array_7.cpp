class Solution {
public:
    int findMiddleIndex(vector<int>& nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        int sumL = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum -= nums[i];
            if (sumL == sum) {
                return i;
            }
            sumL += nums[i];
        }
        return -1;
    }
};