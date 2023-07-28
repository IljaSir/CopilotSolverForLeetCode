class Solution {
public:
    string intToRoman(int num) {
        
        string ans = "";
        int n = num;
        int d = 1;
        while (n) {
            int r = n % 10;
            n /= 10;
            string s = "";
            if (r == 4) {
                s = "IV";
            } else if (r == 9) {
                s = "IX";
            } else {
                if (r >= 5) {
                    s += "V";
                    r -= 5;
                }
                while (r > 0) {
                    s += "I";
                    r--;
                }
            }
            if (d == 2) {
                for (char &c : s) {
                    if (c == 'I') c = 'X';
                    else if (c == 'V') c = 'L';
                    else if (c == 'X') c = 'C';
                }
            } else if (d == 3) {
                for (char &c : s) {
                    if (c == 'I') c = 'C';
                    else if (c == 'V') c = 'D';
                    else if (c == 'X') c = 'M';
                }
            } else if (d == 4) {
                for (char &c : s) {
                    if (c == 'I') c = 'M';
                }
            }
            ans = s + ans;
            d++;
        }
        return ans;
    }
};