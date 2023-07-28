class Solution {
public:
    int minimumTime(string s) {
        
        int n = s.size();
        int i = 0, j = n - 1;
        int res = 0;
        while (i < n && s[i] == '0') {
            ++i;
        }
        while (j >= 0 && s[j] == '0') {
            --j;
        }
        if (i == n) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (i + 1 == j) {
            return 2;
        }
        while (i < j) {
            while (i < j && s[i] == '0') {
                ++i;
            }
            while (i < j && s[j] == '0') {
                --j;
            }
            if (i == j) {
                break;
            }
            res += 2;
            ++i;
            --j;
        }
        return res;
    }
};