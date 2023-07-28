class Solution {
public:
    int closetTarget(vector<string>& words, string target, int startIndex) {
        
        int n = words.size();
        int m = target.size();
        int ans = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int j = 0;
            for (; j < m; ++j) {
                if (words[(startIndex + i) % n][j] != target[j]) {
                    break;
                }
            }
            if (j == m) {
                ans = min(ans, i);
            }
        }
        for (int i = 0; i < n; ++i) {
            int j = 0;
            for (; j < m; ++j) {
                if (words[(startIndex - i + n) % n][j] != target[j]) {
                    break;
                }
            }
            if (j == m) {
                ans = min(ans, i);
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};