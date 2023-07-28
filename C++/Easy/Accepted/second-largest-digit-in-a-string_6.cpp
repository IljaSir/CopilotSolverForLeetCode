class Solution {
public:
    int secondHighest(string s) {
        
        int a[10] = {0};
        for (char c : s) {
            if (isdigit(c)) {
                a[c - '0']++;
            }
        }
        int cnt = 0;
        for (int i = 9; i >= 0; i--) {
            if (a[i] > 0) {
                cnt++;
            }
            if (cnt == 2) {
                return i;
            }
        }
        return -1;
    }
};