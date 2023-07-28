class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2) return n;
        int prediff = nums[1] - nums[0];
        int ans = prediff != 0 ? 2 : 1;
        for (int i = 2; i < n; ++i) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prediff <= 0) || (diff < 0 && prediff >= 0)) {
                ans++;
                prediff = diff;
            }
        }
        return ans;
    }
};