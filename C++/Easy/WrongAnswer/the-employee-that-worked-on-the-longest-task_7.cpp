class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
        
        vector<int> res(n, 0);
        for (int i = 0; i < logs.size(); ++i) {
            int id = logs[i][0];
            int time = logs[i][1];
            if (i > 0) {
                time -= logs[i-1][1];
            }
            res[id] += time;
        }
        int max = 0;
        int id = 0;
        for (int i = 0; i < n; ++i) {
            if (res[i] > max) {
                max = res[i];
                id = i;
            }
        }
        return id;
    }
};