class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        vector<int> first(26, INT_MAX), last(26, INT_MIN);
        for (int i = 0; i < s.size(); i++) {
            int j = s[i] - 'a';
            first[j] = min(first[j], i);
            last[j] = max(last[j], i);
        }
        vector<string> ans;
        int i = 0;
        while (i < s.size()) {
            int j = i;
            while (j <= last[s[i] - 'a']) {
                int k = first[s[j] - 'a'];
                if (k < i) return {};
                j = max(j, last[s[j] - 'a']);
                j++;
            }
            ans.push_back(s.substr(i, j - i));
            i = j;
        }
        return ans;
    }
};