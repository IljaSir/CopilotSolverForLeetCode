class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        
        double waiting = 0;
        int n = customers.size();
        int start = customers[0][0];
        int end = start + customers[0][1];
        for (int i = 1; i < n; i++) {
            if (end >= customers[i][0]) {
                end += customers[i][1];
                waiting += end - customers[i][0];
            } else {
                waiting += customers[i][1];
                start = customers[i][0];
                end = start + customers[i][1];
            }
        }
        return waiting / n;
    }
};