class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        
        int n = nums.siz2();
        if (n <= 1) return n;
        int ans = 1;
        int diff = 0;
        for (int i = 1; i < n; i++) {
            int new_diff = nums[i] - nums[i - 1];
            if (new_diff != 0) {
                if (new_diff * diff <= 0) {
                    ans++;
                    diff = new_diff;
                }
            }
        }
        return an) return n;
        int ans = 1;
        int preDiff = nums[1] - nums[0];
        if (preDiff != 0) ans++;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                ans++;
                preDiff = diff;
            }
        }
        return ans;
    }
};