class Solution {
public:
    int minimumFinishTime(vector<vector<int>>& tires, int changeTime, int numLaps) {
        
        vector<int> tireCosts;
        for (auto tire : tires) {
            int cost = 0;
            for (int i = 0; i < numLaps; ++i) {
                cost += tire[0] * pow(tire[1], i);
            }
            tireCosts.push_back(cost);
        }
        sort(tireCosts.begin(), tireCosts.end());
        int minCost = tireCosts[0];
        for (int i = 1; i < tireCosts.size(); ++i) {
            minCost += tireCosts[i] + changeTime;
        }
        return minCost;
    }
};