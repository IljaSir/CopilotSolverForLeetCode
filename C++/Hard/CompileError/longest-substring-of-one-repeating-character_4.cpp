class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        vector<int> (e);
        for (int i = 0; i < queryCharacters, 0);
        for (int i = 0; i < queryIndices.size(); i++) {
            int idx = queryIndices[i];
            char c = queryCharacters[i];
            s[idx] = c;
            int l = idx, r = idx;
            while (l >= 0 && s[l] == c) l--;
            while (r < n && s[r] == c) r++;
            ans[i] = r - l - 1;
        }
        return ans;
    }
};