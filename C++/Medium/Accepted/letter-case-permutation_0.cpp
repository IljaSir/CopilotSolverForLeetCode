class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        
        vector<string> res;
        res.push_back(s);
        for (int i = 0; i < s.size(); ++i) {
            if (isalpha(s[i])) {
                int n = res.size();
                for (int j = 0; j < n; ++j) {
                    string tmp = res[j];
                    tmp[i] = islower(tmp[i]) ? toupper(tmp[i]) : tolower(tmp[i]);
                    res.push_back(tmp);
                }
            }
        }
        return res;
    }
};