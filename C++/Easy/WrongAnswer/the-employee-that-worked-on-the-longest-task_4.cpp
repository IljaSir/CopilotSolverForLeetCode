class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) {
        
        vector<int> time(n);
        for (auto& log : logs) {
            time[log[0]] += log[1] - (log == logs.front() ? 0 : logs[&log - &logs[0] - 1][1]);
        }
        return max_element(time.begin(), time.end()) - time.begin();
    }
};