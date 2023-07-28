class Solution {
public:
    bool isAdditiveNumber(string num) {
        
        long long a, b, c;
        int n = num.size();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i > 1 && num[0] == '0') break;
                if (j - i > 1 && num[i] == '0') break;
                a = stoll(num.substr(0, i));
                b = stoll(num.substr(i, j - i));
                c = a + b;
                string cstr = to_string(c);
                if (num.substr(j, cstr.size()) == cstr) {
                    int k = j + cstr.size();
                    while (k < n) {
                        a = b;
                        b = c;
                        c = a + b;
                        cstr = to_string(c);
                        if (num.substr(k, cstr.size()) != cstr) {
                            break;
                        }
                        k += cstr.size();
                    }
                    if (k == n) return true;
                }
            }
        }
        return false;
    }
};