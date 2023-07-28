class Solution {
public:
    string predictPartyVictory(string senate) {
        
        int n = senate.size();
        int r = 0, d = 0;
        for (int i = 0; i < n; ++i) {
            if (senate[i] == 'R') ++r;
            else ++d;
        }
        while (r > 0 && d > 0) {
            for (int i = 0; i < n; ++i) {
                if (senate[i] == 'R') {
                    if (d > 0) {
                        --d;
                        senate[i] = 'r';
                    }
                } else if (senate[i] == 'D') {
                    if (r > 0) {
                        --r;
                        senate[i] = 'd';
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                if (senate[i] == 'r') senate[i] = 'R';
                else if (senate[i] == 'd') senate[i] = 'D';
            }
        }
        return r > 0 ? "Radiant" : "Dire";
    }
};