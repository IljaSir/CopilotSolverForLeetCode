class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        
        vector<string> ans;
        ans.push_back(s);
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] >= '0' && s[i] <= '9') continue;
            int n = ans.size();
            for (int j = 0; j < n; ++j) {
                string t = ans[j];
                if (t[i] >= 'a' && t[i] <= 'z') {
                    t[i] = t[i] - 'a' + 'A';
                } else {
                    t[i] = t[i] - 'A' + 'a';
                }
                ans.push_back(t);
            }
        }
        return ans;
    }
};