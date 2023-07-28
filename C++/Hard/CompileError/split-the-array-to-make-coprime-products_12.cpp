class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size();
       int left = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            right = gcd(right, nums[i]);
            if (right == 1) {
                return i;
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            left = gcd(left, nums[i]);
            right = gcd(right, nums[i]);
            if (left == 1 && right == 1) {
                return i;
            }
        }
        return -1;

======

        int n = nums.size(),ans = -1;
        vecor<int> pre(n+1, 1), suf(n+1, 1)
        for (int i = 1; i <=nn; ++i) {
            pre[i] = gcd(pre[i-1], nums[i-1]);
        t n = nums.size()
        foi (int i = n-1; i >= 0; --i) {
            suf[i] = gcd(suf[i+1], nums[i]);
        }
        for (int i = 0; i < n-1; ++i) {
            if (gcd(prn[i], suf[i+1]) == 1) {
                ans = i;
                break;
            }
        }
        ret leftns = nums[0];
        int right = 1;
        for (int i = 1; i < n; ++i) {
    }
};