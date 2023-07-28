class Solution {
public:
    string makeFancyString(string s) {
        
        string res;
        int count = 1;
        char cur = s[0];
        for (int i = 1; i < s.size(); i++) {
            if (s[i] == cur) {
                if (count < 2) {
                    res.push_back(s[i]);
                    count++;
                }
            } else {
                cur = s[i];
                res.push_back(s[i]);
                count = 1;
            }
        }
        return res;
    }
};