class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        int len = tasks.size();
        if (len == 0) return 0;
        if (n == 0) return len;
        int cnt[26] = {0};
        for (auto c : tasks) {
            cnt[c - 'A']++;
        }
        sort(cnt, cnt + 26);
        int max_cnt = cnt[25];
        int ret = (max_cnt - 1) * (n + 1) + 1;
        for (int i = 24; i >= 0; i--) {
            if (cnt[i] == max_cnt) ret++;
            else break;
        }
        return ret < len ? len : ret;
    }
};