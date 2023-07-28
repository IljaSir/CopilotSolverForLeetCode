class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        int n = colors.size();
        vector<int> first(101, n);
        vector<int> last(101, -1);
        for (int i = 0; i < n; ++i) {
            first[colors[i]] = min(first[colors[i]], i);
            last[colors[i]] = max(last[colors[i]], i);
        }
        int ans = 0;
        for (int i = 0; i < 101; ++i) {
            for (int j = i + 1; j < 101; ++j) {
                ans = max(ans, abs(last[i] - first[j]));
                ans = max(ans, abs(last[j] - first[i]));
            }
        }
        return ans;
    }
};