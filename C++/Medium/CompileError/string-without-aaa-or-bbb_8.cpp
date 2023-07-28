class Solution {
public:
    string strWithout3a3b(int a, int b) {
        
        string s;
        while (a || b) {
            int n = s.size();
            if (n >= 2 && s[n-1] == s[n-2]) {
                if (s[n-1] == 'a') {
                    s += 'b';
                    --b;
                } else {
                    s += 'a';
                    --a;
                }
            } else {
                if (a > b) {
                    s += 'a';
                    --a;
                } else {
                    s += 'b';;
            }
        }
        return s;
    }
};