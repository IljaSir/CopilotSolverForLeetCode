class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
        
        vector<int> times(n, 0);
        for (int i = 0; i < logs.size(); i++) {
            times[logs[i][0]] += logs[i][1] - (i == 0 ? 0 : logs[i - 1][1]);
        }
        int max_time = 0;
        int max_id = 0;
        for (int i = 0; i < n; i++) {
            if (max_time < times[i]) {
                max_time = times[i];
                max_id = i;
            }
        }
        return max_id;
    }
};