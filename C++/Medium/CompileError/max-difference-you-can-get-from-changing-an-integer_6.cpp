class Solution {
public:
    int maxDiff(int num) {
        
        string s = to_string(num);
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
        int c = 0, d = ) - min(a, b);
    }
};