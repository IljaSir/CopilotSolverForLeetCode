class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        
        double total = 0;
        int now = 0;
        for (vector<int> c : customers) {
            now = max(now, c[0]) + c[1];
            total += now - c[0];
        }
        return total / customers.size();
    }
};