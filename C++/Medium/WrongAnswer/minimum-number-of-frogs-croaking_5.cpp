class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int c = 0, r = 0, o = 0, a = 0, k = 0, frogs = 0, maxFrogs = 0;
        for (char ch: croakOfFrogs) {
            if (ch == 'c') {
                c++;
                frogs++;
            } else if (ch == 'r') {
                if (c == 0) return -1;
                r++;
                c--;
            } else if (ch == 'o') {
                if (r == 0) return -1;
                o++;
                r--;
            } else if (ch == 'a') {
                if (o == 0) return -1;
                a++;
                o--;
            } else if (ch == 'k') {
                if (a == 0) return -1;
                k++;
                a--;
                frogs--;
            }
            maxFrogs = max(maxFrogs, frogs);
        }
        if (c != 0 || r != 0 || o != 0 || a != 0 || k != 0) return -1;
        return maxFrogs;
    }
};