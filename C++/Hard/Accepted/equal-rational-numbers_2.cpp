class Solution {
public:
    bool isRationalEqual(string s, string t) {
        
        return toDouble(s) == toDouble(t);
    }
    double toDouble(string s) {
        int pos = s.find('(');
        if (pos == string::npos) {
            return stod(s);
        }
        string base = s.substr(0, pos);
        string repeat = s.substr(pos + 1, s.length() - pos - 2);
        for (int i = 0; i < 20; ++i) {
            base += repeat;
        }
        return stod(base);
    }
};