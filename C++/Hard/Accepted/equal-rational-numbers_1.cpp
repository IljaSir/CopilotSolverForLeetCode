class Solution {
public:
    bool isRationalEqual(string s, string t) {
        
        return parse(s) == parse(t);
    }
    double parse(string s) {
        int i = s.find('(');
        if (i != string::npos) {
            string base = s.substr(0, i);
            string rep = s.substr(i + 1, s.size() - i - 2);
            for (int i = 0; i < 20; i++) base += rep;
            return stod(base);
        }
        return stod(s);
    }
};