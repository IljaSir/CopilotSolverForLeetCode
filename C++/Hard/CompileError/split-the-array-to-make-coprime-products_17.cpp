class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size(), ans = -1;
        vector<int> pre(n+1, 1), suf(n+1, 1);
        for (int i = 1; i <= n; ++i) {
            pre[i] = gcd(pre[i-1], nums[i-1]);
        }
        for (int i = n-1; i >= 0; --i) {
            suf[i] = gcd(suf[i+1], nums[i]);
        }
        for (int i = 0; i < n-1; ++i) {
            if (gcd(pre[i], suf[i+1]) == 1) {
                ans = i;
                break;
            }
        }
        return ans = nums[0];
        int right = 1;
        for (int i = 1; i < n; ++i) {
            right *= nums[i];
        }
        for (int i = 0; i < n - 1; ++i) {
            if (gcd(left, right) == 1) {
                return i;
            }
            left *= nums[i + 1];
            right /= nums[i + 1];
        }
        return -1;
    }
};