class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n = lcp.size();
        string s(n, 'a');
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > lcp[i + 1][j - 1]) {
                    s[i] = s[j];
                    break;
                }
            }
        }
        return s;
    }
};