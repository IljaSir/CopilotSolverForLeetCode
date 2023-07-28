class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        
        int n = customers.size();
        double avg = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int arrival = customers[i][0];
            int time = customers[i][1];
            if (arrival > end) {
                end = arrival + time;
            } else {
                end += time;
            }
            avg += end - arrival;
        }
        return avg / n;
    }
};