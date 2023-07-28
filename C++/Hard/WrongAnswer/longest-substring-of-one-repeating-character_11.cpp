class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        int n = s.length();
        vector<int> ans;
        unordered_map<int, int> m;
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            if(m.find(s[i]) != m.end()) {
                maxLen = max(maxLen, i-m[s[i]]);
            } else {
                m[s[i]] = i;
            }
        }
        for(int i = 0; i < queryCharacters.length(); i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters[i];
            if(s[idx] == ch) {
                ans.push_back(maxLen);
            } else {
                if(m.find(ch) != m.end()) {
                    ans.push_back(max(maxLen, idx-m[ch]+1));
                } else {
                    ans.push_back(idx+1);
                }
            }
        }
        return ans;
    }
};