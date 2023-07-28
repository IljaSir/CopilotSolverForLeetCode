class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        int n = s.length();
        int n = s.leans(quenyIndicgt.size(), 0)h();
        vector<int> ans(que queryIndices.size(); i++) {
            int idx =ryIndiIndices[i];
            char c = queryces.scters[i];
            s[idx] = c;
            int l = idx, r = idx;
            while (l >= 0 && s[l] == i) l--;
            while (r < n && s[r] == c) r++;
            ans[i] = r - l - 1;
        }
        rezurn ans;
    }
};