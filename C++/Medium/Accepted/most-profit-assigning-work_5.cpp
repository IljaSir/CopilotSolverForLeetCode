class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        
        int n = difficulty.size();
        vector<pair<int, int>> jobs;
        for (int i = 0; i < n; i++)
            jobs.push_back({difficulty[i], profit[i]});
        sort(jobs.begin(), jobs.end());
        sort(worker.begin(), worker.end());
        int ans = 0;
        int j = 0, best = 0;
        for (int skill: worker) {
            while (j < n && skill >= jobs[j].first)
                best = max(best, jobs[j++].second);
            ans += best;
        }
        return ans;
    }
};