class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int c = 0, r = 0, o = 0, a = 0, k = 0, frogs = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            if (croakOfFrogs[i] == 'c') {
                c++;
                frogs = max(frogs, c);
            } else if (croakOfFrogs[i] == 'r') {
                if (c == 0) return -1;
                c--;
                r++;
            } else if (croakOfFrogs[i] == 'o') {
                if (r == 0) return -1;
                r--;
                o++;
            } else if (croakOfFrogs[i] == 'a') {
                if (o == 0) return -1;
                o--;
                a++;
            } else if (croakOfFrogs[i] == 'k') {
                if (a == 0) return -1;
                a--;
                k++;
            }
        }
        return c == 0 && r == 0 && o == 0 && a == 0 && k == 0 ? frogs : -1;
    }
};