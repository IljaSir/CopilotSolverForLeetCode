class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        int res = 0;
        int m = tasks.size();
        vector<int> cnt(26, 0);
        for (auto c : tasks) {
            cnt[c - 'A']++;
        }
        sort(cnt.begin(), cnt.end());
        int maxCnt = cnt[25];
        int i = 25;
        while (i >= 0 && cnt[i] == maxCnt) {
            i--;
        }
        res = max((maxCnt - 1) * (n + 1) + 25 - i, m);
        return res;
    }
};