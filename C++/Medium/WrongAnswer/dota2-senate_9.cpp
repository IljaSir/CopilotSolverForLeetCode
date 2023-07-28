class Solution {
public:
    string predictPartyVictory(string senate) {
        
        int n = senate.size();
        int r = 0, d = 0;
        for (auto c : senate) {
            if (c == 'R') r++;
            else d++;
        }
        int r2 = r, d2 = d;
        int i = 0;
        while (r2 > 0 && d2 > 0) {
            if (senate[i] == 'R') {
                if (d > 0) {
                    d--;
                    d2--;
                    senate[i] = '0';
                }
            } else if (senate[i] == 'D') {
                if (r > 0) {
                    r--;
                    r2--;
                    senate[i] = '0';
                }
            }
            i++;
            if (i == n) i = 0;
        }
        return r2 > 0 ? "Radiant" : "Dire";
    }
};