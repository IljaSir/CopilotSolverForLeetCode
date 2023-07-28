class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> r(n, n);
        int k = n;
        for (int i = n - 1; i >= 0; --i) {
            while (k < n && nums[i] > nums[r[k]])
                k = r[k];
            r[i] = k;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i)
            ans = max(ans, r[i] - i);
        return ans;
    }
};