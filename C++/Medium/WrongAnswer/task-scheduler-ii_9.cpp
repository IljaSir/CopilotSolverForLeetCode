class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        long long n = tasks.size();
        vector<int> cnt(1000001, 0);
        for (auto x : tasks) cnt[x]++;
        sort(cnt.begin(), cnt.end(), greater<int>());
        long long max_cnt = 0;
        for (int i = 0; i < 1000001; i++) {
            if (cnt[i] == cnt[0]) max_cnt++;
            else break;
        }
        long long ans = (cnt[0] - 1) * (space + 1) + max_cnt;
        return max(ans, n);
    }
};