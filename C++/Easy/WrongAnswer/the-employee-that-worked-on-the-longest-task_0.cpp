class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
        
        vector<int> time(n, 0);
        for (int i = 1; i < logs.size(); i++) {
            time[logs[i][0]] += logs[i][1] - logs[i-1][1];
        }
        int maxTime = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (time[i] > maxTime) {
                maxTime = time[i];
                res = i;
            }
        }
        return res;
    }
};