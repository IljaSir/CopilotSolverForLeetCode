class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        
        vector<string> res = {s};
        int n = s.size();
        for (int i = 0; i < n; i++) {
            if (isalpha(s[i])) {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    string tmp = res[j];
                    if (islower(tmp[i])) {
                        tmp[i] = toupper(tmp[i]);
                    } else {
                        tmp[i] = tolower(tmp[i]);
                    }
                    res.push_back(tmp);
                }
            }
        }
        return res;
    }
};