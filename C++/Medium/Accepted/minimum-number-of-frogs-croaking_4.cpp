class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int c = 0, r = 0, o = 0, a = 0, k = 0, frogs = 0, max_frogs = 0;
        for (char ch : croakOfFrogs) {
            if (ch == 'c') {
                c++;
                frogs++;
                max_frogs = max(max_frogs, frogs);
            } else if (ch == 'r') {
                if (c <= r) return -1;
                r++;
            } else if (ch == 'o') {
                if (r <= o) return -1;
                o++;
            } else if (ch == 'a') {
                if (o <= a) return -1;
                a++;
            } else if (ch == 'k') {
                if (a <= k) return -1;
                k++;
                frogs--;
            }
        }
        return c == r && r == o && o == a && a == k ? max_frogs : -1;
    }
};