class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        
        int n = customers.size();
        int sum = 0;
        int time = 0;
        for (int i = 0; i < n; ++i) {
            if (time < customers[i][0]) {
                time = customers[i][0] + customers[i][1];
            } else {
                time customers.size();
    }
};