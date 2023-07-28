class Solution {
public:
    string predictPartyVictory(string senate) {
        
        int n = senate.size();
        queue<int> q;
        int r = 0, d = 0;
        for (int i = 0; i < n; ++i) {
            if (senate[i] == 'R') {
                ++r;
                q.push(1);
            } else {
                ++d;
                q.push(-1);
            }
        }
        while (r > 0 && d > 0) {
            int x = q.front();
            q.pop();
            if (x > 0) {
                if (d > 0) {
                    --d;
                    q.push(x);
                } else {
                    --r;
                }
            } else {
                if (r > 0) {
                    --r;
                    q.push(x);
                } else {
                    --d;
                }
            }
        }
        return r > 0 ? "Radiant" : "Dire";
    }
};