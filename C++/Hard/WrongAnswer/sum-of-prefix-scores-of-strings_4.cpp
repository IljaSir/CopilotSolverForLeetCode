class Solution {
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        int n = words.size();
        vector<int> ans(n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= words[i].size(); ++j) {
                for (int k = 0; k < n; ++k) {
                    if (words[k].size() > j && words[k].substr(0, j) == words[i].substr(0, j)) {
                        ans[i] += 1;
                    }
                }
            }
        }
        return ans;
    }
};