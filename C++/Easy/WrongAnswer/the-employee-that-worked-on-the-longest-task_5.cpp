class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
        
        vector<int> work(n, 0);
        for (int i = 0; i < logs.size(); i++) {
            if (i > 0) {
                work[logs[i][0]] += logs[i][1] - logs[i - 1][1];
            } else {
                work[logs[i][0]] += logs[i][1];
            }
        }
        int maxTime = 0;
        int maxWorker = 0;
        for (int i = 0; i < n; i++) {
            if (work[i] > maxTime) {
                maxTime = work[i];
                maxWorker = i;
            }
        }
        return maxWorker;
    }
};