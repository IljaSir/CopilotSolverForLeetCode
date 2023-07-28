class Solution {
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        vector<int> ans(words.size(), 0);
        unordered_map<string, int> m;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words[i].size(); j++) {
                string substr = words[i].substr(0, j + 1);
                m[substr]++;
            }
        }
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words[i].size(); j++) {
                string substr = words[i].substr(0, j + 1);
                ans[i] += m[substr];
            }
        }
        return ans;
    }
};