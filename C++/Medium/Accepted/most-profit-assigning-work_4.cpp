class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        
        int n = difficulty.size();
        vector<vector<int>> jobs(n, vector<int>(2, 0));
        for (int i = 0; i < n; ++i) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        sort(jobs.begin(), jobs.end());
        sort(worker.begin(), worker.end());
        int ans = 0;
        int i = 0, best = 0;
        for (int ability: worker) {
            while (i < n && ability >= jobs[i][0]) {
                best = max(best, jobs[i][1]);
                ++i;
            }
            ans += best;
        }
        return ans;
    }
};