class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
        
        vector<int> times(n, 0);
        int maxTime = 0;
        int maxId = 0;
        for (int i = 0; i < logs.size(); ++i) {
            int id = logs[i][0];
            int time = logs[i][1];
            if (i > 0) {
                time -= logs[i - 1][1];
            }
            times[id] += time;
            if (times[id] > maxTime) {
                maxTime = times[id];
                maxId = id;
            }
        }
        return maxId;
    }
};