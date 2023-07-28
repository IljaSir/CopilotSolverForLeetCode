class Solution {
public:
    bool isRationalEqual(string s, string t) {
        
        double a = parse(s);
        double b = parse(t);
        return abs(a - b) < 1e-10;
    }
    double parse(string s) {
        int i = s.find('(');
        if (i == string::npos) return stod(s);
        int j = s.find(')');
        string a = s.substr(0, i);
        string b = s.substr(i + 1, j - i - 1);
        int c = j - i - 1;
        int k = s.find('.');
        if (k == string::npos) {
            return stod(a) + stod(b) / pow(10, c);
        }
        int d = s.length() - j - 1;
        return stod(a) + stod(b) / pow(10, c) + stod(s.substr(j + 1)) / pow(10, d);
    }
};