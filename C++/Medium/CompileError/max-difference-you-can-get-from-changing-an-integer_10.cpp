class Solution {
public:
    int maxDiff(int num) {
        
        string s = to_string(num);
        int a = 0, b = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != '9') {
                a = a * 10 + (s[i] - '0') + 1;
                break;
            } else {
                a = a * 10 + 9;
            }
        }
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != '0') {
                if (s[i] != '1') {
                    b = b * 10 + 1;
                } else {
                    b = b * 10 + 0;
                }
                break;
            } else {;
    }
};