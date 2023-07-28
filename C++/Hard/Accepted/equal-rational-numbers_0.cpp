class Solution {
public:
    bool isRationalEqual(string s, string t) {
        
        return f(s) == f(t);
    }
    double f(string s) {
        int i = s.find("(");
        if (i >= 0) {
            string a = s.substr(0, i);
            string b = s.substr(i + 1, s.size() - i - 2);
            for (int i = 0; i < 20; ++i) a += b;
            return stod(a);
        }
        return stod(s);
    }
};