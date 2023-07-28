class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        
        vector<string> res;
        res.push_back(s);
        for (int i = 0; i < s.size(); i++) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    string t = res[j];
                    t[i] = t[i] - 'a' + 'A';
                    res.push_back(t);
                }
            }
            if (s[i] >= 'A' && s[i] <= 'Z') {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    string t = res[j];
                    t[i] = t[i] - 'A' + 'a';
                    res.push_back(t);
                }
            }
        }
        return res;
    }
};