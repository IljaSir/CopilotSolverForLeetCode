class Solution {
public:
    int trap(vector<int>& height) {
        
        int n = height.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            left[i] = max(left[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = max(right[i + 1], height[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            int h = min(left[i], right[i]);
            if (h > height[i]) {
                ans += h - height[i];
            }
        }
        return ans;
    }
};