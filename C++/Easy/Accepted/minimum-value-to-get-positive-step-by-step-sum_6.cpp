class Solution {
public:
    int minStartValue(vector<int>& nums) {
        
        int min = 0;
        int sum = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum < min) {
                min = sum;
            }
        }
        int ans = 1 - min;
        if (ans < 1) {
            ans = 1;
        }
        return ans;
    }
};