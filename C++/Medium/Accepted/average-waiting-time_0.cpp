class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        
        double sum = 0;
        int t = 0;
        for (auto& c : customers) {
            t = max(t, c[0]) + c[1];
            sum += t - c[0];
        }
        return sum / customers.size();
    }
};