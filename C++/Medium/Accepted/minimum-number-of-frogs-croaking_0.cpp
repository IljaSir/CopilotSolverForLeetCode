class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int n = croakOfFrogs.size();
        if (n % 5 != 0) return -1;
        int c = 0, r = 0, o = 0, a = 0, k = 0, res = 0;
        for (char ch : croakOfFrogs) {
            if (ch == 'c') {
                c++;
                res = max(res, c);
            }
            else if (ch == 'r') {
                r++;
                if (r > c) return -1;
            }
            else if (ch == 'o') {
                o++;
                if (o > r) return -1;
            }
            else if (ch == 'a') {
                a++;
                if (a > o) return -1;
            }
            else if (ch == 'k') {
                k++;
                if (k > a) return -1;
                c--;
                r--;
                o--;
                a--;
                k--;
            }
        }
        return c == 0 ? res : -1;
    }
};