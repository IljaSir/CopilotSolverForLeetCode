class Solution {
public:
    int maxDiff(int num) {
        
        string s = to_string(num);
        int n = s.size();
        int a = 0;
        int b = 0;
        bool flag = false;
        for (int i = 0; i < n; i++) {
            if (s[i] == '9' && !flag) {
                a = a * 10 + (s[i] - '0');
                b = b * 10 + (s[i] - '0');
            }
            else if (!flag) {
                flag = true;
                a = a * 10 + 9;
                b = b * 10 + (s[i] - '0');
            }
            else {
                a = a * 10 + (s[i] - '0');
                if (s[i] == '1') {
                    b = b * 10 + (s[i] - '0');
                }
                else {
                    b = b * 10 + 1;
                }
            }
        }
        return a - b;
    }
};