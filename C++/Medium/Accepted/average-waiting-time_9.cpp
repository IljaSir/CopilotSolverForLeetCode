class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        
        int n = customers.size();
        double sum = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int cur = max(customers[i][0], prev);
            sum += (cur - customers[i][0] + customers[i][1]);
            prev = cur + customers[i][1];
        }
        return sum / n;
    }
};