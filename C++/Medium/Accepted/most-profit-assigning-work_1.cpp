class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        
        vector<pair<int, int>> jobs;
        for (int i = 0; i < difficulty.size(); ++i) {
            jobs.push_back(make_pair(difficulty[i], profit[i]));
        }
        sort(jobs.begin(), jobs.end());
        sort(worker.begin(), worker.end());
        int maxProfit = 0;
        int bestProfit = 0;
        int i = 0;
        for (int ability: worker) {
            while (i < jobs.size() && jobs[i].first <= ability) {
                bestProfit = max(bestProfit, jobs[i].second);
                ++i;
            }
            maxProfit += bestProfit;
        }
        return maxProfit;
    }
};