class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        vector<int> res;
        for (int i = 0; i < queryCharacters.size(); ++i) {
            int l = queryIndices[i];
            int r = l;
            while (l >= 0 && s[l] == queryCharacters[i]) {
                --l;
            }
            while (r < s.size() && s[r] == queryCharacters[i]) {
                ++r;
            }
            res.push_back(r - l - 1);
        }
        return res;
    }
};