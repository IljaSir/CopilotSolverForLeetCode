class Solution {
public:
    string convertToBase7(int num) {
        
        string s = "";
        bool flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }
        while (num) {
            s += (num % 7 + '0');
            num /= 7;
        }
        if (flag) s += '-';
        reverse(s.begin(), s.end());
        return s;
    }
};