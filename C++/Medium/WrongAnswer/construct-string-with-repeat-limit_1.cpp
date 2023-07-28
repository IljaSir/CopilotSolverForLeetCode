class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) {
        
        string ret;
        int cnt = 1;
        char last = s[0];
        ret.push_back(last);
        for (int i = 1; i < s.size(); ++i) {
            if (s[i] == last) {
                ++cnt;
                if (cnt <= repeatLimit) {
                    ret.push_back(last);
                }
            } else {
                last = s[i];
                cnt = 1;
                ret.push_back(last);
            }
        }
        return ret;
    }
};