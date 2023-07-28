class Solution {
public:
    string predictPartyVictory(string senate) {
        
        queue<int> q;
        int n = senate.size();
        int r = 0, d = 0;
        for (int i = 0; i < n; i++) {
            if (senate[i] == 'R') {
                r++;
            } else {
                d++;
            }
            q.push(senate[i]);
        }
        while (r > 0 && d > 0) {
            int c = q.front();
            q.pop();
            if (c == 'R') {
                if (d > 0) {
                    d--;
                } else {
                    r--;
                    q.push(c);
                }
            } else {
                if (r > 0) {
                    r--;
                } else {
                    d--;
                    q.push(c);
                }
            }
        }
        return r > 0 ? "Radiant" : "Dire";
    }
};