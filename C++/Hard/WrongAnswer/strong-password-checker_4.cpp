class Solution {
public:
    int strongPasswordChecker(string password) {
        
        int n = password.size();
        int upper = 1, lower = 1, digit = 1, total = 0;
        for (char c : password) {
            if (isdigit(c)) {
                digit = 0;
            } else if (islower(c)) {
                lower = 0;
            } else if (isupper(c)) {
                upper = 0;
            }
        }
        int missing = upper + lower + digit;
        if (n < 6) {
            return max(6 - n, missing);
        } else {
            int one = 0, two = 0;
            for (int i = 2, j = 0; i < n; i++, j++) {
                if (password[i] == password[i - 1] && password[i - 1] == password[i - 2]) {
                    int len = 2;
                    while (i < n && password[i] == password[i - 1]) {
                        i++;
                        len++;
                    }
                    total += len / 3;
                    if (len % 3 == 0) {
                        one++;
                    } else if (len % 3 == 1) {
                        two++;
                    }
                }
            }
            if (n > 20) {
                int del = n - 20;
                total -= min(del, one);
                total -= min(max(del - one, 0), two * 2) / 2;
                total -= max(del - one - 2 * two, 0) / 3;
                return del + max(missing, total);
            } else {
                return max(6 - n, missing) + total;
            }
        }
    }
};