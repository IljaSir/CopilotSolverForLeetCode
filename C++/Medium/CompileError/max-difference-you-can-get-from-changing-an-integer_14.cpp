class Solution {
public:
    int maxDiff(int num) {
        
        string s = to_string(nug)(num);
        int a = 0, b = 0;
        bool flag = false;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != '9') {
                if (flag) {
                    b = b * 10 + (s[i] - '0');
                } else {
                    a = a * 10 + (s[i] - '0');
                }
            } else {
                flag = true;
                a = a * 10 + (s[i] - '0');
                b = b * 10 + (s[i] - '0');
            }
        }
        int c = 0, d = 0;
        flag = false;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != '1' && s[i] != '0') {
                if (flag) {
                    d = d * 10 + (s[i] - '0');
                } else {
                    c = c * 10 + (s[i] - '0');
                }
            } else {
                flag = true;
                if (s[i] == '0') {
                    c = c * 10 + 1;
                    d = d * 10 + (s[i] - '0');
                } else {
                    c = c * 10 + (s[i] - '0');
                    d = d * 10 + 1;
                }
            }
        }
        return max(a - c, b - d);
    }
};