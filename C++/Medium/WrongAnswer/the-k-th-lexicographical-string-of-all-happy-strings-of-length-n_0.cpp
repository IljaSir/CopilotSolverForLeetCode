class Solution {
public:
    string getHappyString(int n, int k) {
        
        string s;
        for (int i = 0; i < n; ++i) {
            s += 'a';
        }
        --k;
        while (k > 0) {
            int i = n - 1;
            while (i >= 0 && s[i] == 'c') {
                --i;
            }
            if (i < 0) {
                return "";
            }
            ++s[i];
            for (int j = i + 1; j < n; ++j) {
                s[j] = 'a';
            }
            --k;
        }
        return s;
    }
};