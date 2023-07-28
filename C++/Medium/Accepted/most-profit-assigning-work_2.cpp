class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        
        vector<pair<int, int>> jobs;
        for (int i = 0; i < difficulty.size(); ++i) {
            jobs.push_back(make_pair(difficulty[i], profit[i]));
        }
        sort(jobs.begin(), jobs.end());
        sort(worker.begin(), worker.end());
        int ans = 0;
        int i = 0;
        int best = 0;
        for (int skill : worker) {
            while (i < jobs.size() && skill >= jobs[i].first) {
                best = max(best, jobs[i].second);
                ++i;
            }
            ans += best;
        }
        return ans;
    }
};