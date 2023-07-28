class Solution {
public:
    int findMiddleIndex(vector<int>& nums) {
        
        int sum = 0;
        for (auto x : nums) {
            sum += x;
        }
        int left = 0, right = sum;
        for (int i = 0; i < nums.size(); i++) {
            right -= nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
};