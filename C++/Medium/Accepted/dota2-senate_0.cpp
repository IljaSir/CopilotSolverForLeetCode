class Solution {
public:
    string predictPartyVictory(string senate) {
        
        int n = senate.size();
        queue<int> qR, qD;
        for (int i = 0; i < n; ++i) {
            if (senate[i] == 'R') {
                qR.push(i);
            } else {
                qD.push(i);
            }
        }
        while (!qR.empty() && !qD.empty()) {
            int r = qR.front();
            qR.pop();
            int d = qD.front();
            qD.pop();
            if (r < d) {
                qR.push(r + n);
            } else {
                qD.push(d + n);
            }
        }
        return qR.size() > qD.size() ? "Radiant" : "Dire";
    }
};