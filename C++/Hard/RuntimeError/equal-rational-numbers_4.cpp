class Solution {
public:
    bool isRationalEqual(string s, string t) {
        
        return getRational(s) == getRational(t);
    }
    
    double getRational(string s) {
        int pos = s.find("(");
        if (pos == string::npos) {
            return stod(s);
        }
        string base = s.substr(0, pos);
        string rep = s.substr(pos + 1, s.size() - pos - 2);
        int len = rep.size();
        double res = stod(base.substr(0, base.find("."))) + stod(base.substr(base.find(".") + 1)) / pow(10, base.size() - base.find(".") - 1);
        for (int i = 0; i < 20; ++i) {
            res += stod(rep) / pow(10, base.size() - base.find(".") - 1) / pow(10, len) / pow(10, i);
        }
        return res;
    }
};