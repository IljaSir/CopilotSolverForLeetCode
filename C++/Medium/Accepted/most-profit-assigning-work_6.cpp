class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        
        vector<pair<int, int>> vp;
        for (int i = 0; i < difficulty.size(); i++) {
            vp.push_back({difficulty[i], profit[i]});
        }
        sort(vp.begin(), vp.end());
        int maxProfit = 0;
        for (int i = 0; i < vp.size(); i++) {
            maxProfit = max(maxProfit, vp[i].second);
            vp[i].second = maxProfit;
        }
        int res = 0;
        for (int i = 0; i < worker.size(); i++) {
            int j = upper_bound(vp.begin(), vp.end(), make_pair(worker[i], INT_MAX)) - vp.begin();
            if (j > 0) {
                res += vp[j - 1].second;
            }
        }
        return res;
    }
};