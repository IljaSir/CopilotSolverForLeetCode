class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        
        vector<string> res;
        int n = s.size();
        for (int i = 0; i < (1 << n); i++) {
            string t = s;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    if (t[j] >= 'a' && t[j] <= 'z') {
                        t[j] -= 32;
                    } else if (t[j] >= 'A' && t[j] <= 'Z') {
                        t[j] += 32;
                    }
                }
            }
            res.push_back(t);
        }
        return res;
    }
};