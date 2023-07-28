class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        int n = tasks.size();
        vector<int> cnt(100001, 0);
        for (int task : tasks) {
            cnt[task]++;
        }
        sort(cnt.begin(), cnt.end());
        int maxCnt = cnt[100000];
        int maxCntCnt = 0;
        for (int i = 100000; i >= 0; i--) {
            if (cnt[i] == maxCnt) {
                maxCntCnt++;
            } else {
                break;
            }
        }
        return max((long long)n, (long long)(maxCnt - 1) * (space + 1) + maxCntCnt);
    }
};