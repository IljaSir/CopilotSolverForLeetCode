class Solution {
public:
    string orderlyQueue(string s, int k) {
        
        if (k > 1) {
            sort(s.begin(), s.end());
            return s;
        }
        string res = s;
        for (int i = 0; i < s.size(); ++i) {
            string t = s.substr(i) + s.substr(0, i);
            if (t < res) res = t;
        }
        return res;
    }
};