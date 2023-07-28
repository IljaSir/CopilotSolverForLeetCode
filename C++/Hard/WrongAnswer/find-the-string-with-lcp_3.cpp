class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n = lcp.size();
        string ans;
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            while (j < n && lcp[i][j] == lcp[i][j - 1]) {
                ++j;
            }
            ans += string(1, 'a' + j - i - 1);
        }
        return ans;
    }
};