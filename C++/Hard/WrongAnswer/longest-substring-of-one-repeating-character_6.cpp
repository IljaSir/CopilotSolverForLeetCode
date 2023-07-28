class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        vector<int> ans(queryIndices.size(), 0);
        for (int i = 0; i < queryIndices.size(); i++) {
            int idx = queryIndices[i];
            char c = queryCharacters[i];
            char old = s[idx];
            s[idx] = c;
            int l = idx, r = idx;
            while (l >= 0 && s[l] == c) l--;
            while (r < s.size() && s[r] == c) r++;
            ans[i] = r - l - 1;
            s[idx] = old;
        }
        return ans;
    }
};