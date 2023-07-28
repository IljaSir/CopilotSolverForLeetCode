class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> a(n);
        for (int i = 0; i < n; ++i) {
            a[i] = (nums[i] & 1) ? 1 : 0;
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (a[i] == 0) {
                ans += 1;
                continue;
            }
            int l = i;
            int r = i;
            while (l > 0 && a[l - 1] == 1) {
                --l;
            }
            while (r < n - 1 && a[r + 1] == 1) {
                ++r;
            }
            ans += (long long)(i - l + 1) * (r - i + 1);
        }
        return ans;
    }
};