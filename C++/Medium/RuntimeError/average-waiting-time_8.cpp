class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        
        int n = customers.size();
        int current = customers[0][0];
        int total = 0;
        for (int i = 0; i < n; ++i) {
            int arrival = customers[i][0];
            int time = customers[i][1];
            if (current < arrival) {
                current = arrival;
            }
            total += current - arrival + time;
            current += time;
        }
        return total * 1.0 / n;
    }
};