class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
        
        vector<int> time(n, 0);
        int max = 0;
        int id = 0;
        for(int i = 0; i < logs.size(); i++) {
            time[logs[i][0]] += logs[i][1] - (i == 0 ? 0 : logs[i-1][1]);
            if(time[logs[i][0]] > max) {
                max = time[logs[i][0]];
                id = logs[i][0];
            }
        }
        return id;
    }
};