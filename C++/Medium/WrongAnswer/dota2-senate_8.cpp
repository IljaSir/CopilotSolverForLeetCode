class Solution {
public:
    string predictPartyVictory(string senate) {
        
        int n = senate.size();
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            q.push(i);
        }
        int cnt[2] = {0};
        for (int i = 0; i < n; ++i) {
            if (senate[i] == 'R') {
                cnt[0]++;
            } else {
                cnt[1]++;
            }
        }
        while (cnt[0] > 0 && cnt[1] > 0) {
            int x = q.front();
            q.pop();
            if (senate[x] == 'R') {
                if (cnt[1] > 0) {
                    cnt[1]--;
                    senate[x] = '0';
                } else {
                    q.push(x);
                }
            } else {
                if (cnt[0] > 0) {
                    cnt[0]--;
                    senate[x] = '0';
                } else {
                    q.push(x);
                }
            }
        }
        if (cnt[0] > 0) {
            return "Radiant";
        }
        return "Dire";
    }
};