class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> pos(n, 0);
        vector<int> neg(n, 0);
        if (nums[0] > 0) pos[0] = 1;
        if (nums[0] < 0) neg[0] = 1;
        int ans = pos[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                pos[i] = pos[i-1] + 1;
                if (neg[i-1] > 0) neg[i] = neg[i-1] + 1;
            }
            if (nums[i] < 0) {
                neg[i] = pos[i-1] + 1;
                if (neg[i-1] > 0) pos[i] = neg[i-1] + 1;
            }
            ans = max(ans, pos[i]);
        }
        return ans;
    }
};