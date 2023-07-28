class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        vector<int> left(n), right(n), top(n), bottom(n);
        for (int i = 0; i < n; i++) {
            int x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            left[i] = x - r;
            right[i] = x + r;
            top[i] = y - r;
            bottom[i] = y + r;
        }
        sort(left.begin(), left.end());
        sort(right.begin(), right.end());
        sort(top.begin(), top.end());
        sort(bottom.begin(), bottom.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            int l = lower_bound(right.begin(), right.end(), x - r) - right.begin();
            int r = upper_bound(left.begin(), left.end(), x + r) - left.begin();
            int t = lower_bound(bottom.begin(), bottom.end(), y - r) - bottom.begin();
            int b = upper_bound(top.begin(), top.end(), y + r) - top.begin();
            ans = max(ans, r - l + b - t - 1);
        }
        return ans;
    }
};