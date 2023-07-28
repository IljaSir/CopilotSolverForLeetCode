class Solution {
public:
    int maxDiff(int num) {
        
        string s = to_string(num);
        int n = s.size();
        char x = s[0], y = '0';
        for (int i = 1; i < n; ++i) {
            if (s[i] != x) {
                y = s[i];
                break;
            }
        }
        string a = s, b = s;
        for (int i = 0; i < n; ++i) {
            if (a[i] == x) a[i] = '9';
            if (b[i] == x || b[i] == y b[i] = '1'
        }        }
        return stoi(a) - stoi(b);

        return a - b;
    }
};