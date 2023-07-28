class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n = lcp.size();
        vector<string> strs(n, "");
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int k = lcp[i][j];
                if (k > 0) {
                    strs[i].push_back(strs[j][k - 1]);
                }
                else {
                    for (int c = 0; c < 26; ++c) {
                        char ch = c + 'a';
                        if (strs[i].find(ch) == string::npos && strs[j].find(ch) == string::npos) {
                            strs[i].push_back(ch);
                            strs[j].push_back(ch);
                            break;
                        }
                    }
                }
            }
        }
        string ans = strs[0];
        for (int i = 1; i < n; ++i) {
            if (ans.compare(strs[i]) > 0) {
                ans = strs[i];
            }
        }
        return ans;
    }
};