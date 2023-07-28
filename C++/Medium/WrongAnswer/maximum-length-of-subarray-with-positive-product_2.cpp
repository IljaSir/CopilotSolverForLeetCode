class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos = pos + 1;
                if (neg > 0) {
                    neg = neg + 1;
                }
            } else if (nums[i] < 0) {
                int tmp = neg;
                neg = pos + 1;
                pos = tmp + 1;
            } else {
                pos = 0;
                neg = 0;
            }
            ans = max(ans, pos);
        }
        return ans;
    }
};