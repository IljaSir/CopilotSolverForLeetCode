class Solution {
public:
    string predictPartyVictory(string senate) {
        
        int n = senate.size();
        queue<int> q;
        for (int i = 0; i < n; i++) {
            q.push(i);
        }
        int ban[2] = {0, 0};
        while (q.size() > 1) {
            int i = q.front();
            q.pop();
            if (senate[i] == 'R') {
                if (ban[1] > 0) {
                    ban[1]--;
                } else {
                    ban[0]++;
                    q.push(i);
                }
            } else {
                if (ban[0] > 0) {
                    ban[0]--;
                } else {
                    ban[1]++;
                    q.push(i);
                }
            }
        }
        return senate[q.front()] == 'R' ? "Radiant" : "Dire";
    }
};