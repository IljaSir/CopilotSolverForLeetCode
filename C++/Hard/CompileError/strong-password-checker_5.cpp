class Solution {
public:
    int strongPasswordChecker(string password) {
        
        int ans = 0;
        int n = password.size();
        int needType = 3;
        if (n < 6) {
            ans = max(6 - n, needType);
        }
        int lower = 1, upper = 1, digit = 1;
        vector<int> repeat;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && password[i] == password[j]) {
                j++;
            }
            if (password[i] >= 'a' && password[i] <= 'z') {
                lower = 0;
            }
            if (password[i] >= 'A' && password[i] <= 'Z') {
                upper = 0;
            }
            if (password[i] >= '0' && password[i] <= '9') {
                digit = 0;
            }
            if (j - i >= 3) {
                repeat.push_back(j - i);
            }
        }
        needType = lower + upper + digit;
        if (n <= 20) {
            ans = max(needType, ans);
            int one = 0, two = 0;
            for (int k: repeat) {
                one += k / 3;
                if (k % 3 == 0) {
                    two++;
                }
            }
            ans += max(one - two, 0);
        } else {
            int del = n - 20;
            ans += del;
            int i = 0;
            while (i < repeat.size() && del) {
                int need = (repeat[i] % 3 == 0) ? 1 : 0;
                if (del >= need) {
                    if (repeat[i] - need < 3) {
                        one--;
                    }
                    repeat[i] -= need;
                    del -= need;
                } else {
                    i++;
                }
            }
            i = 0;
            while (i < repeat.size() && del) {
                if (del >= 2) {
                    if (repeat[i] < 3) {
                        one--;
                    }
                    repeat[i] -= 2;
                    del -= 2;
                } else {
                    i++;
                }
            }
            int need = max(needType, del);
            ans += need;
            int two =
    }
};