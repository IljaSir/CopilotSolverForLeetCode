class Solution {
public:
    string predictPartyVictory(string senate) {
        
        int n = senate.size();
        int r = 0, d = 0;
        for (int i = 0; i < n; ++i) {
            if (senate[i] == 'R') ++r;
            else ++d;
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            q.push(i);
        }
        while (r != 0 && d != 0) {
            int i = q.front();
            q.pop();
            if (senate[i] == 'R') {
                if (d > 0) {
                    --d;
                    senate[i] = 'X';
                } else {
                    q.push(i);
                }
            } else {
                if (r > 0) {
                    --r;
                    senate[i] = 'X';
                } else {
                    q.push(i);
                }
            }
        }
        return r > d ? "Radiant" : "Dire";
    }
};