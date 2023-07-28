class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        
        int ans = 0;
        for (int i = 0; i < numsDivide.size(); ++i) {
            int min = INT_MAX;
            for (int j = 0; j < nums.size(); ++j) {
                if (numsDivide[i] % nums[j] == 0 && nums[j] < min) {
                    min = nums[j];
                }
            }
            if (min == INT_MAX) {
                return -1;
            }
            if (numsDivide[i] % min != 0) {
                ans++;
            }
        }
        return ans;
    }
};