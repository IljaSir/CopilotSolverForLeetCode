class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int positive = 0;
        int negative = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                positive = 0;
                negative = 0;
            } else if (nums[i] > 0) {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            } else {
                int temp = positive;
                positive = negative > 0 ? negative + 1 : 0;
                negative = temp + 1;
            }
            ans = max(ans, positive);
        }
        return ans;
    }
};