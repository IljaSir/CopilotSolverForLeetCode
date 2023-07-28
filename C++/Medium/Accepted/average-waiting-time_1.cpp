class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        
        double ret = 0;
        int cur = 0;
        for (auto& c : customers) {
            cur = max(cur, c[0]) + c[1];
            ret += cur - c[0];
        }
        return ret / customers.size();
    }
};