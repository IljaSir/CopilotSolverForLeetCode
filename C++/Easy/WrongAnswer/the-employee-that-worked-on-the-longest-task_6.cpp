class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
        
        vector<int> work(n, 0);
        for (int i = 0; i < logs.size(); i++) {
            int id = logs[i][0];
            int time = logs[i][1];
            if (i == 0) {
                work[id] += time;
            } else {
                work[id] += time - logs[i - 1][1];
            }
        }
        int maxTime = 0;
        int maxId = 0;
        for (int i = 0; i < n; i++) {
            if (work[i] > maxTime) {
                maxTime = work[i];
                maxId = i;
            }
        }
        return maxId;
    }
};