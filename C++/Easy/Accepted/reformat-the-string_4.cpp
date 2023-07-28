class Solution {
public:
    string reformat(string s) {
        
        string a, b, c;
        for (auto ch : s) {
            if (ch >= '0' && ch <= '9') {
                a += ch;
            } else {
                b += ch;
            }
        }
        if (abs(int(a.size()) - int(b.size())) > 1) {
            return "";
        }
        if (a.size() > b.size()) {
            c = a;
            a = b;
            b = c;
        }
        c = "";
        for (int i = 0; i < a.size(); i++) {
            c += b[i];
            c += a[i];
        }
        if (b.size() > a.size()) {
            c += b.back();
        }
        return c;
    }
};