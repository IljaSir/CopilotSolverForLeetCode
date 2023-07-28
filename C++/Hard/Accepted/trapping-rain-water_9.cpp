class Solution {
public:
    int trap(vector<int>& height) {
        
        int n = height.size();
        if (n == 0)
            return 0;
        int maxh = height[0];
        int maxl[n];
        int maxr[n];
        for (int i = 0; i < n; i++) {
            maxl[i] = maxh;
            maxh = max(maxh, height[i]);
        }
        maxh = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxr[i] = maxh;
            maxh = max(maxh, height[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += max(0, min(maxl[i], maxr[i]) - height[i]);
        }
        return ans;
    }
};