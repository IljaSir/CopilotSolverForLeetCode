class Solution {
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        int n = words.size();
        vector<int> ans(n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (words[i].size() > words[j].size() && words[i].substr(0, words[j].size()) == words[j]) {
                    ans[i] += ans[j] + 1;
                }
            }
        }
        return ans;
    }
};