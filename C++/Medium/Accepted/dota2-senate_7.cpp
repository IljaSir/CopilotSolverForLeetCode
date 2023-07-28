class Solution {
public:
    string predictPartyVictory(string senate) {
        
        int n = senate.size();
        queue<int> q;
        int ban[2] = {0, 0};
        int cnt[2] = {0, 0};
        for (int i = 0; i < n; ++i) {
            int x = senate[i] == 'R' ? 0 : 1;
            q.push(x);
            ++cnt[x];
        }
        while (cnt[0] > 0 && cnt[1] > 0) {
            int x = q.front();
            q.pop();
            if (ban[x] > 0) {
                --ban[x];
                --cnt[x];
            } else {
                ++ban[x ^ 1];
                q.push(x);
            }
        }
        return cnt[0] > 0 ? "Radiant" : "Dire";
    }
};