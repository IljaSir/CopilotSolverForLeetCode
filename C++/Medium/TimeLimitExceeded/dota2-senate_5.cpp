class Solution {
public:
    string predictPartyVictory(string senate) {
        
        int n = senate.size();
        int r = 0, d = 0;
        vector<int> ban(n, 0);
        for (int i = 0; i < n; ++i) {
            if (senate[i] == 'R') {
                ++r;
            } else {
                ++d;
            }
        }
        while (r > 0 && d > 0) {
            for (int i = 0; i < n; ++i) {
                if (!ban[i]) {
                    if (senate[i] == 'R') {
                        --d;
                        ban[i] = 1;
                        for (int j = i + 1; j < n; ++j) {
                            if (!ban[j] && senate[j] == 'D') {
                                ban[j] = 1;
                                break;
                            }
                        }
                    } else {
                        --r;
                        ban[i] = 1;
                        for (int j = i + 1; j < n; ++j) {
                            if (!ban[j] && senate[j] == 'R') {
                                ban[j] = 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return r > 0 ? "Radiant" : "Dire";
    }
};