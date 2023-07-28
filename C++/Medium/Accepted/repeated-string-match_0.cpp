class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        
        string s = a;
        for (int rep = 1; rep <= b.size() / a.size() + 2; ++rep, s += a) {
            if (s.find(b) != string::npos) {
                return rep;
            }
        }
        return -1;
    }
};