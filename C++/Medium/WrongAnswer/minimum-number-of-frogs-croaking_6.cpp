class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int c = 0, r = 0, o = 0, a = 0, k = 0, frogs = 0, maxFrogs = 0;
        for (char ch: croakOfFrogs) {
            switch(ch) {
                case 'c':
                    c++;
                    frogs++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'k':
                    k++;
                    frogs--;
                    break;
            }
            if (r > c || o > r || a > o || k > a) {
                return -1;
            }
            maxFrogs = max(maxFrogs, frogs);
        }
        return maxFrogs;
    }
};