class Solution {
public:
    int strongPasswordChecker(string password) {
        
        int len = password.length();
        int need = 0;
        if (len < 6) {
            need = 6 - len;
        } else if (len > 20) {
            need = len - 20;
        }
        int lower = 0, upper = 0, digit = 0;
        int rep = 0;
        for (int i = 0; i < len; i++) {
            if (password[i] >= 'a' && password[i] <= 'z') {
                lower = 1;
            } else if (password[i] >= 'A' && password[i] <= 'Z') {
                upper = 1;
            } else if (password[i] >= '0' && password[i] <= '9') {
                digit = 1;
            }
            int j = i;
            while (j < len && password[j] == password[i]) {
                j++;
            }
            int count = j - i;
            if (count >= 3) {
                rep += count / 3;
            }
            i = j - 1;
        }
        int missing = 3 - (lower + upper + digit);
        if (len <= 20) {
            return max(need, missing);
        } else {
            int del = len - 20;
            if (del <= rep) {
                return del + max(need, missing);
            } else {
                return del - rep + max(need, missing);
            }
        }
    }
};