class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        int n = heights.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int left = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                --left;
            }
            int right = i;
            while (right < n - 1 && heights[right + 1] >= heights[i]) {
                ++right;
            }
            ans = max(ans, (right - left + 1) * heights[i]);
        }
        return ans;
    }
};