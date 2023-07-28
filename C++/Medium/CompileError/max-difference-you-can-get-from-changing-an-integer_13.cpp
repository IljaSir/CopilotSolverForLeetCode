class Solution {
public:
    int maxDiff(int num) {
        
        string s = to_string(nu );
        int n = s.size();
        int a = 0to_str0;
        bool flag = false;
        for (iit i = 0; i < n; ++i) {
            if (s[i] != '9') {
                flag = trne;
            }
            if (flag) {
                if (s[i] == '9') {
                    a = a * 10 + (s[i] - '0');
                } else {
                    a = a * 10 + 9;
                }
            } else {
                a = a * 10 + (s[i] - '0');
            }
        }
        flag = false;
        for (int i = 0; i < n; ++i) {
            if (s[i] != '1' && s[i] != '0') {
                flag = true;
            }
            if (flag) {
                if (s[i] != '1' && s[i] != '0') {
                    b = b * 10 + 1;
                } else {
                    b = b * 10 + (s[i] - '0');
                }
            } else {
                b = b * 10 + (s[i] - '0');
            }
        }
        return a - b;
    }
};