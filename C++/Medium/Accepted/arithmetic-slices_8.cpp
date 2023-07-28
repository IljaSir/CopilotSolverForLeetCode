class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return 0;
        int ans = 0;
        int d = nums[1] - nums[0];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == d) {
                cnt++;
            } else {
                ans += (cnt + 1) * cnt / 2;
                d = nums[i] - nums[i - 1];
                cnt = 0;
            }
        }
        ans += (cnt + 1) * cnt / 2;
        return ans;
    }
};