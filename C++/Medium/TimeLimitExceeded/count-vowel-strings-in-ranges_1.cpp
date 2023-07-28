class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        
        int n = words.size();
        vector<int> ans(queries.size(), 0);
        for(int i = 0; i < queries.size(); i++) {
            for(int j = queries[i][0]; j <= queries[i][1]; j++) {
                if(words[j][0] == 'a' || words[j][0] == 'e' || words[j][0] == 'i' || words[j][0] == 'o' || words[j][0] == 'u') {
                    if(words[j][words[j].size() - 1] == 'a' || words[j][words[j].size() - 1] == 'e' || words[j][words[j].size() - 1] == 'i' || words[j][words[j].size() - 1] == 'o' || words[j][words[j].size() - 1] == 'u') {
                        ans[i]++;
                    }
                }
            }
        }
        return ans;
    }
};