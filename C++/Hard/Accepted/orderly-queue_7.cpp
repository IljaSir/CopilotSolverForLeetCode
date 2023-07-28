class Solution {
public:
    string orderlyQueue(string s, int k) {
        
        if (k == 1) {
            string res = s;
            for (int i = 0; i < s.length(); ++i) {
                string s1 = s.substr(i);
                string s2 = s.substr(0, i);
                res = min(res, s1 + s2);
            }
            return res;
        }
        sort(s.begin(), s.end());
        return s;
    }
};