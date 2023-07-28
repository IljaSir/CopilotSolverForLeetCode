class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int maxFrogs = 0;
        for (auto ch : croakOfFrogs) {
            switch(ch) {
                case 'c': ++c; break;
                case 'r': ++r; break;
                case 'o': ++o; break;
                case 'a': ++a; break;
                case 'k': ++k; break;
            }
            maxFrogs = max(maxFrogs, c - k);
            if (r > c || o > r || a > o || k > a) return -1;
        }
        return c == k ? maxFrogs : -1;
    }
};