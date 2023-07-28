class Solution {
public:
    int maxDiff(int num) {
        
        string s = to_string(num);
        string a = s, b = s;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] != '9') {
                a[i] = '9';
                break;
            }
        }
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] != '1' && s[i] != '0') {
                b[i] = '1';
                break;
            }
        }
        if (b[0] == '0') {
            for (int i = 0; i < s.size(); ++i) {
                if (s[i] != '0') {
                    b[i] = '0';
                    break;
                }
            }
        }
        return stoi(a) - stoi(b);
    }
};