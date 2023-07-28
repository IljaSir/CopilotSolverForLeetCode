class Solution {
public:
    int strongPasswordChecker(string password) {
        
        int n = password.size();
        int lower = 1, upper = 1, digit = 1;
        vector<int> v;
        for (int i = 0; i < n;) {
            if (islower(password[i])) lower = 0;
            if (isupper(password[i])) upper = 0;
            if (isdigit(password[i])) digit = 0;
            int j = i;
            while (i < n && password[i] == password[j]) i++;
            if (i - j >= 3) v.push_back(i - j);
        }
        int missing = lower + upper + digit;
        if (n < 6) {
            return max(missing, 6 - n);
        } else if (n <= 20) {
            return max(missing, check(v));
        } else {
            int del = n - 20;
            int need = check(v);
            if (del >= need) return del;
            else {
                int ans = 0;
                for (int i = 0; i < v.size(); i++) {
                    if (del >= v[i] - 2) {
                        del -= v[i] - 2;
                        v[i] = 2;
                    } else if (del >= v[i] % 3) {
                        v[i] -= del;
                        del = 0;
                    }
                    if (v[i] >= 3) ans++;
                }
                return n - 20 + max(missing, ans);
            }
        }
    }
    
    int check(vector<int>& v) {
        int ans = 0;
        for (int i = 0; i < v.size(); i++) {
            ans += v[i] / 3;
        }
        return ans;
    }
};