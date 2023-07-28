class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        string res;
        while (a || b || c) {
            int n = res.size();
            if (n >= 2 && res[n - 1] == res[n - 2]) {
                if (res[n - 1] == 'a' && b >= c) {
                    res += 'b';
                    b--;
                } else if (res[n - 1] == 'b' && a >= c) {
                    res += 'a';
                    a--;
                } else {
                    res += 'c';
                    c--;
                }
            } else {
                if (a >= b && a >= c && a) {
                    res += 'a';
                    a--;
                } else if (b >= a && b >= c && b) {
                    res += 'b';
                    b--;
                } else if (c >= a && c >= b && c) {
                    res += 'c';
                    c--;
                } else {
                    break;
                }
            }
        }
        return res;
    }
};