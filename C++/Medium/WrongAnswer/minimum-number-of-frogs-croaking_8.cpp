class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int maxFrogs = 0;
        for (auto ch : croakOfFrogs) {
            switch (ch) {
                case 'c':
                    c++;
                    maxFrogs = max(maxFrogs, c);
                    break;
                case 'r':
                    if (c == 0) return -1;
                    c--;
                    r++;
                    break;
                case 'o':
                    if (r == 0) return -1;
                    r--;
                    o++;
                    break;
                case 'a':
                    if (o == 0) return -1;
                    o--;
                    a++;
                    break;
                case 'k':
                    if (a == 0) return -1;
                    a--;
                    k++;
                    break;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) return -1;
        return maxFrogs;
    }
};