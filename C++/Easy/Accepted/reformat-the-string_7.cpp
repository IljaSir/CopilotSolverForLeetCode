class Solution {
public:
    string reformat(string s) {
        
        string ss, dd;
        for (auto c : s) {
            if (isdigit(c)) {
                dd.push_back(c);
            } else {
                ss.push_back(c);
            }
        }
        if (abs((int)ss.size() - (int)dd.size()) > 1) {
            return "";
        }
        if (ss.size() < dd.size()) {
            swap(ss, dd);
        }
        string res;
        for (int i = 0; i < ss.size(); i++) {
            res.push_back(ss[i]);
            if (i < dd.size()) {
                res.push_back(dd[i]);
            }
        }
        return res;
    }
};