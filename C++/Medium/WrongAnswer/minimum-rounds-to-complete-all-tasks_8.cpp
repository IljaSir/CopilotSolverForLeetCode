class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        int n = tasks.size();
        int res = 0;
        int cnt[4] = {0};
        for (int i = 0; i < n; i++) {
            int idx = (tasks[i] + 7) / 8;
            cnt[idx]++;
        }
        int cur = 0;
        for (int i = 1; i < 4; i++) {
            if (cnt[i] == 0) continue;
            int r = cur % 2;
            int t = (cnt[i] + 2 - r) / 2;
            res += t;
            cur = (t * 2 - cnt[i]) % 2;
        }
        return cur == 0 ? res : res + 1;
    }
};